package io.siuolplex.wood_you_dye.fabric;

import io.siuolplex.wood_you_dye.WoodYouDyeMain;
import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import io.siuolplex.wood_you_dye.util.Loader;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class WoodYouDye implements ModInitializer {
    public static final Loader MODLOADER = new WYDFabricLoader();

    @Override
    public void onInitialize() {
        WoodYouDyeMain.init(MODLOADER);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
            for (Item item : WoodYouDyeItems.itemGroupHolder) {
                content.addBefore(Items.STONE.getDefaultInstance(), item.getDefaultInstance());
            }
        });
    }

    public static class WYDFabricLoader implements Loader {
        @Override
        public String getName() {
            return "fabric";
        }

        @Override
        public boolean getIsClient() {
            return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
        }

        @Override
        public <T> T register(T registeredObject, String id) {
            if (registeredObject instanceof Block block) {
                return (T) Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath("wood_you_dye", id), block);
            } else if (registeredObject instanceof Item item) {
                return (T) Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath("wood_you_dye", id), item);
            }
            else return null;
        }
    }
}
