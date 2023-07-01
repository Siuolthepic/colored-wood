package io.siuolplex.wood_you_dye;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class WoodYouDyeClient implements ClientModInitializer {
    public void onInitializeClient(ModContainer mod) {
        for (DyeColor color : DyeColor.values()) {
            BlockRenderLayerMap.put(RenderLayer.getTranslucent(), Registries.BLOCK.get(new Identifier("wood_you_dye", color.toString().toLowerCase() + "_plank_door")));
            BlockRenderLayerMap.put(RenderLayer.getCutout(), Registries.BLOCK.get(new Identifier("wood_you_dye", color.toString().toLowerCase() + "_plank_trapdoor")));
        }
    }
}
