package io.siuolplex.wood_you_dye.forge.mixin;

import io.siuolplex.wood_you_dye.registry.WoodYouDyeBlocks;
import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Items.class)
public class ItemsMixin {
    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void ISTG(CallbackInfo ci) {
        WoodYouDyeItems.init();
    }
}
