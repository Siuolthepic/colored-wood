package io.siuolplex.wood_you_dye.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

// Based on similar code by supersaiyansubtlety, made for Defaulted Drops, which is licensed under MIT, and found here: https://gitlab.com/supersaiyansubtlety-group/minecraft-mods/defaulted_drops/-/tree/master/
@Mixin(BlockBehaviour.class)
public abstract class AbstractBlockMixin {
    @Shadow
    public abstract Item asItem();

    @Inject(method = "", cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD, at = @At(value = "RETURN"))
    private void addSelfIfNoLootTable(BlockState state, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {

        if (state.getBlock().getLootTable().location().getNamespace().equals("wood_you_dye")) {
            if (state.getBlock() instanceof SlabBlock && state.getValue(SlabBlock.TYPE).equals(SlabType.DOUBLE)) {
                cir.setReturnValue(List.of(new ItemStack(this.asItem()), new ItemStack(this.asItem())));
            } else if (state.getBlock() instanceof DoorBlock && state.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                cir.setReturnValue(List.of(Items.AIR.getDefaultInstance()));
            } else if (state.getBlock() instanceof SignBlock sign) {
                cir.setReturnValue(List.of(new ItemStack(sign.asItem())));
            } else {
                cir.setReturnValue(List.of(new ItemStack(this.asItem())));
            }
        }
    }
}

