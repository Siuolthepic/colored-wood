package io.siuolplex.wood_you_dye;

import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import io.siuolplex.wood_you_dye.util.Loader;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.loader.api.minecraft.MinecraftQuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import static net.minecraft.item.ItemGroups.BUILDING_BLOCKS;

public class WoodYouDye implements ModInitializer {
    public static final Loader MODLOADER = new WYDQuiltLoader();

    @Override
    public void onInitialize(ModContainer mod) {
        WoodYouDyeMain.init(MODLOADER);
        ItemGroupEvents.modifyEntriesEvent(BUILDING_BLOCKS).register(content -> {
            for (Item item : WoodYouDyeItems.itemGroupHolder) {
                content.addBefore(Items.STONE.getDefaultStack(), item.getDefaultStack());
            }
        });
    }


    public static class WYDQuiltLoader implements Loader {
        @Override
        public String getName() {
            return "quilt";
        }

        @Override
        public boolean getIsClient() {
            return MinecraftQuiltLoader.getEnvironmentType() == EnvType.CLIENT;
        }

        @Override
        public <T> T register(T registeredObject, String id) {
            if (registeredObject instanceof Block block) {
                return (T) Registry.register(Registries.BLOCK, new Identifier("wood_you_dye", id), block);
            } else if (registeredObject instanceof Item item) {
                return (T) Registry.register(Registries.ITEM, new Identifier("wood_you_dye", id), item);
            }
            else return null;
        }
    }
}
