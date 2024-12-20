package io.siuolplex.wood_you_dye.fabric;

import io.siuolplex.wood_you_dye.WoodYouDyeMain;
import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import io.siuolplex.wood_you_dye.util.Loader;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

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

    }
}
