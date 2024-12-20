package io.siuolplex.wood_you_dye.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import io.siuolplex.wood_you_dye.block.sign.WoodYouDyeSign;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Code is based on Terraform
// Found here: https://github.com/TerraformersMC/Terraform/blob/1.19.4/terraform-wood-api-v1/src/main/java/com/terraformersmc/terraform/sign/mixin/MixinSignBlockEntityRenderer.java
@Mixin(SignRenderer.class)
public abstract class SignRendererMixin {
    @Unique
    protected SignBlockEntity woodYouDye$renderedSignEntity;

    @Inject(method = "render(Lnet/minecraft/world/level/block/entity/SignBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "HEAD"))
    private void setRenderedToSign(SignBlockEntity signBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, CallbackInfo ci) {
        this.woodYouDye$renderedSignEntity = signBlockEntity;
    }

    @Inject(method = "getSignMaterial", at = @At("HEAD"), cancellable = true)
    private void getSignTextureId(CallbackInfoReturnable<Material> ci) {
        if (this.woodYouDye$renderedSignEntity != null) {
            if (this.woodYouDye$renderedSignEntity.getBlockState().getBlock() instanceof WoodYouDyeSign sign) {
                ci.setReturnValue(new Material(Sheets.SIGN_SHEET, sign.getTexture()));
            }
        }
    }
}
