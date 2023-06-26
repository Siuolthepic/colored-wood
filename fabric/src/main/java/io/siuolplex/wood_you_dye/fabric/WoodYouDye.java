package io.siuolplex.wood_you_dye.fabric;

import io.siuolplex.wood_you_dye.WoodYouDyeMain;
import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class WoodYouDye implements ModInitializer {
    @Override
    public void onInitialize() {
        WoodYouDyeMain.init();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            for (Item item : WoodYouDyeItems.itemGroupHolder) {
                content.addAfter(Items.WARPED_BUTTON.getDefaultStack(), item.getDefaultStack());
            }
        });
    }
}
