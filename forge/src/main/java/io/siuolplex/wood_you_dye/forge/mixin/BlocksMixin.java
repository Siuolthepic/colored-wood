package io.siuolplex.wood_you_dye.forge.mixin;

import io.siuolplex.wood_you_dye.registry.WoodYouDyeBlocks;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// WHY DOES THIS WORK GENUINELY WHAT THE FUCK THIS IS INCREDIBLE BUT STILL WHAT THE FUCK LMFAOOOOOO
@Mixin(Blocks.class)
public class BlocksMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void ifThisWorksIWillFlip(CallbackInfo ci) {
        WoodYouDyeBlocks.init();
    }
}
