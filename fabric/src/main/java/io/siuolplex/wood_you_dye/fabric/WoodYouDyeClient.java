package io.siuolplex.wood_you_dye.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class WoodYouDyeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (DyeColor color : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier("wood_you_dye", color.toString().toLowerCase() + "_plank_door")), RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putBlock(Registries.BLOCK.get(new Identifier("wood_you_dye", color.toString().toLowerCase() + "_plank_trapdoor")), RenderLayer.getCutout());
        }
    }
}
