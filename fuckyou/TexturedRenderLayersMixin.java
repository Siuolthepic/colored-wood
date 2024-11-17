package io.siuolplex.wood_you_dye.mixin;

import net.minecraft.client.render.TexturedRenderLayers;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {
    // Is this even used what
    /*@Inject(method = "addDefaultTextures", at = @At("RETURN"))
    private static void injectSoulIceSigns(Consumer<Material> adder, CallbackInfo ci) {
        for(Material identifier: SpriteIdentifierRegistry.INSTANCE.getIdentifiers()) {
            adder.accept(identifier);
        }
    }*/
}