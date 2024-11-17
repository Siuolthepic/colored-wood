package io.siuolplex.wood_you_dye.block.sign;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodYouDyeHangingWallSignBlock extends WallHangingSignBlock implements WoodYouDyeHangingSign {
    private final ResourceLocation guiTexture;
    private final ResourceLocation texture;

    public WoodYouDyeHangingWallSignBlock(WoodType type, BlockBehaviour.Properties settings) {
        super(type, settings);
        this.texture = ResourceLocation.fromNamespaceAndPath("wood_you_dye", "entity/signs/hanging/" + type.name());
        this.guiTexture = ResourceLocation.fromNamespaceAndPath("wood_you_dye", "textures/gui/hanging_sign/" + type.name());
    }

    @Override
    public ResourceLocation getGuiTexture() {
        return guiTexture;
    }

    @Override
    public ResourceLocation getTexture() {
        return texture;
    }
}
