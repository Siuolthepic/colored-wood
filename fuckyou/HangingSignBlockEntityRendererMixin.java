package io.siuolplex.wood_you_dye.mixin;

import io.siuolplex.wood_you_dye.block.sign.WoodYouDyeSign;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Code is based on Terraform
// Found here: https://github.com/TerraformersMC/Terraform/blob/1.19.4/terraform-wood-api-v1/src/main/java/com/terraformersmc/terraform/sign/mixin/MixinHangingSignBlockEntityRenderer.java
@Mixin(HangingSignRenderer.class)
public abstract class HangingSignBlockEntityRendererMixin {
    @Unique protected SignBlockEntity soulIce$renderedBlockEntity;

    @Inject(method = "render(Lnet/minecraft/block/entity/SignBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", at = @At(value = "HEAD"))
    private void setRenderedToSign(SignBlockEntity signBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, CallbackInfo ci) {
        this.soulIce$renderedBlockEntity = signBlockEntity;
    }

    @Inject(method = "getTextureId", at = @At("HEAD"), cancellable = true)
    private void getHangingSignTextureId(CallbackInfoReturnable<SpriteIdentifier> ci) {
        if (this.soulIce$renderedBlockEntity != null) {
            if (this.soulIce$renderedBlockEntity.getCachedState().getBlock() instanceof WoodYouDyeSign sign) {
                ci.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, sign.getTexture()));
            }
        }
    }
}