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
public abstract class SignBlockEntityRendererMixin {
    @Unique
    protected SignBlockEntity soulIce$renderedBlockEntity;

    @Inject(method = "render(Lnet/minecraft/world/level/block/entity/SignBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "HEAD"))
    private void setRenderedToSign(SignBlockEntity signBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, CallbackInfo ci) {
        this.soulIce$renderedBlockEntity = signBlockEntity;
    }

    /*@Redirect(method = "method_32158", at = @At(value = "NEW", target = "(Lnet/minecraft/client/model/ModelPart;)Lnet/minecraft/client/render/block/entity/SignBlockEntityRenderer$SignModel;"))
    private static SignBlockEntityRenderer.SignModel motherfucker(ModelPart modelPart, BlockEntityRendererFactory.Context ctx, SignType signType) {
        if (signType.setType().name().equals("wyd_wood")) return (new SignBlockEntityRenderer.SignModel(ctx.getLayerModelPart(new EntityModelLayer(new Identifier("wood_you_dye", "sign/" + signType.getName()), "main"))));
        else return new SignBlockEntityRenderer.SignModel(ctx.getLayerModelPart(EntityModelLayers.createSign(signType)));
    }*/

    @Inject(method = "getSignMaterial", at = @At("HEAD"), cancellable = true)
    private void getSignTextureId(CallbackInfoReturnable<Material> ci) {
        if (this.soulIce$renderedBlockEntity != null) {
            if (this.soulIce$renderedBlockEntity.getBlockState().getBlock() instanceof WoodYouDyeSign sign) {
                ci.setReturnValue(new Material(Sheets.SIGN_SHEET, sign.getTexture()));
            }
        }
    }
}
