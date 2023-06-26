package io.siuolplex.wood_you_dye.block.sign;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class WoodYouDyeHangingWallSignBlock extends WallHangingSignBlock implements WoodYouDyeHangingSign {
    private final Identifier guiTexture;
    private final Identifier texture;

    public WoodYouDyeHangingWallSignBlock(AbstractBlock.Settings settings, SignType type) {
        super(settings, type);
        this.texture = new Identifier("wood_you_dye", "entity/signs/hanging/" + type.getName());
        this.guiTexture = new Identifier("wood_you_dye", "textures/gui/hanging_sign/" + type.getName());
    }

    @Override
    public Identifier getGuiTexture() {
        return guiTexture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }
}
