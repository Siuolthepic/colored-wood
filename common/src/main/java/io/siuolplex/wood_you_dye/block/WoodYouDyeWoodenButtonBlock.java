package io.siuolplex.wood_you_dye.block;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WoodYouDyeWoodenButtonBlock extends ButtonBlock {
    public WoodYouDyeWoodenButtonBlock(BlockSetType type, int pressTicks, BlockBehaviour.Properties settings) {
        super(type, pressTicks, settings);
    }
}
