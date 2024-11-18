package io.siuolplex.wood_you_dye.forge;

import io.siuolplex.wood_you_dye.registry.WoodYouDyeBlocks;
import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = "wood_you_dye", bus = EventBusSubscriber.Bus.MOD)
public class WoodYouDyeForgeRegistration {
    @SubscribeEvent
    public static void registrationTime(RegisterEvent event) {
        if (event.getRegistry() == BuiltInRegistries.BLOCK) {
            WoodYouDyeBlocks.init();
        } else if (event.getRegistry() == BuiltInRegistries.ITEM) {
            WoodYouDyeItems.init();
        }
    }
}
