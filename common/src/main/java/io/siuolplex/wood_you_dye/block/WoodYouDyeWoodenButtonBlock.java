package io.siuolplex.wood_you_dye.block;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.AbstractButtonBlock;

public class WoodYouDyeWoodenButtonBlock extends AbstractButtonBlock {
    public WoodYouDyeWoodenButtonBlock(Settings settings) {
        super(settings.noCollision(), BlockSetType.OAK, 20, true);
    }
}
