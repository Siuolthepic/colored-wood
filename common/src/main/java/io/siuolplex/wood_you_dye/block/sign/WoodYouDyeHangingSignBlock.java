package io.siuolplex.wood_you_dye.block.sign;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CeilingHangingSignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

// Code is based on Terraform
// Original found here: https://github.com/TerraformersMC/Terraform/blob/1.19.4/terraform-wood-api-v1/src/main/java/com/terraformersmc/terraform/sign/block/TerraformSignBlock.java
public class WoodYouDyeHangingSignBlock extends CeilingHangingSignBlock implements WoodYouDyeHangingSign {
    private final Identifier guiTexture;
    private final Identifier texture;

    public WoodYouDyeHangingSignBlock(AbstractBlock.Settings settings, SignType type) {
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
