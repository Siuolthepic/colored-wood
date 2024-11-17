package io.siuolplex.wood_you_dye.mixin;

import io.siuolplex.wood_you_dye.block.sign.WoodYouDyeSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

// Code is based on Terraform
// Found here: https://github.com/TerraformersMC/Terraform/blob/1.19.4/terraform-wood-api-v1/src/main/java/com/terraformersmc/terraform/sign/mixin/MixinSignEditScreen.java
@Mixin(SignEditScreen.class)
@Environment(EnvType.CLIENT)
public class SignEditScreenMixin{
    @Shadow @Nullable private SignBlockEntityRenderer.SignModel model;

    @ModifyVariable(method = "renderSignBackground", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/render/TexturedRenderLayers;getSignTextureId(Lnet/minecraft/block/WoodType;)Lnet/minecraft/client/util/SpriteIdentifier;"))
    private SpriteIdentifier getSignTextureId(SpriteIdentifier spriteIdentifier, DrawContext context, BlockState state) {
        if (state.getBlock() instanceof WoodYouDyeSign sign) {
            return new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, sign.getTexture());
        }
        return spriteIdentifier;
    }
}