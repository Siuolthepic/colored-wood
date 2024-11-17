package io.siuolplex.wood_you_dye.forge;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = WoodYouDye.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WoodYouDyeClient {
    @SubscribeEvent
    public static void onInitializeClient(final FMLClientSetupEvent event) {
        for (DyeColor color : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("wood_you_dye", color.toString().toLowerCase() + "_plank_door")), RenderType.TRANSLUCENT);
            ItemBlockRenderTypes.setRenderLayer(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("wood_you_dye", color.toString().toLowerCase() + "_plank_trapdoor")), RenderType.cutout());
        }
    }
}
