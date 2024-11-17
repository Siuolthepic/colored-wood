package io.siuolplex.wood_you_dye.fabric;

import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class WoodYouDyeDatagen implements DataGeneratorEntrypoint {
    
    
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        generator.createPack().addProvider(WYDRecipeProvider::new);
    }



    public static class WYDRecipeProvider extends RecipeProvider {
        private static final List<Item> DYES_LIST = List.of(Items.RED_DYE, Items.ORANGE_DYE, Items.YELLOW_DYE,
                Items.LIME_DYE, Items.GREEN_DYE, Items.BLUE_DYE, Items.CYAN_DYE, Items.LIGHT_BLUE_DYE, Items.PURPLE_DYE,
                Items.PINK_DYE, Items.MAGENTA_DYE, Items.BROWN_DYE, Items.WHITE_DYE, Items.LIGHT_GRAY_DYE, Items.GRAY_DYE, Items.BLACK_DYE);

        private static final List<Item> PLANKS = List.of(WoodYouDyeItems.RED_PLANKS, WoodYouDyeItems.ORANGE_PLANKS,
                WoodYouDyeItems.YELLOW_PLANKS, WoodYouDyeItems.LIME_PLANKS, WoodYouDyeItems.GREEN_PLANKS, WoodYouDyeItems.BLUE_PLANKS,
                WoodYouDyeItems.CYAN_PLANKS, WoodYouDyeItems.LIGHT_BLUE_PLANKS, WoodYouDyeItems.PURPLE_PLANKS, WoodYouDyeItems.PINK_PLANKS,
                WoodYouDyeItems.MAGENTA_PLANKS, WoodYouDyeItems.BROWN_PLANKS, WoodYouDyeItems.WHITE_PLANKS, WoodYouDyeItems.LIGHT_GRAY_PLANKS,
                WoodYouDyeItems.GRAY_PLANKS, WoodYouDyeItems.BLACK_PLANKS);

        private static final List<Item> SLABS = List.of(WoodYouDyeItems.RED_PLANK_SLAB, WoodYouDyeItems.ORANGE_PLANK_SLAB,
                WoodYouDyeItems.YELLOW_PLANK_SLAB, WoodYouDyeItems.LIME_PLANK_SLAB, WoodYouDyeItems.GREEN_PLANK_SLAB, WoodYouDyeItems.BLUE_PLANK_SLAB,
                WoodYouDyeItems.CYAN_PLANK_SLAB, WoodYouDyeItems.LIGHT_BLUE_PLANK_SLAB, WoodYouDyeItems.PURPLE_PLANK_SLAB,
                WoodYouDyeItems.PINK_PLANK_SLAB, WoodYouDyeItems.MAGENTA_PLANK_SLAB, WoodYouDyeItems.BROWN_PLANK_SLAB, WoodYouDyeItems.WHITE_PLANK_SLAB,
                WoodYouDyeItems.LIGHT_GRAY_PLANK_SLAB, WoodYouDyeItems.GRAY_PLANK_SLAB, WoodYouDyeItems.BLACK_PLANK_SLAB);

        private static final List<Item> STAIRS = List.of(WoodYouDyeItems.RED_PLANK_STAIRS, WoodYouDyeItems.ORANGE_PLANK_STAIRS,
                WoodYouDyeItems.YELLOW_PLANK_STAIRS, WoodYouDyeItems.LIME_PLANK_STAIRS, WoodYouDyeItems.GREEN_PLANK_STAIRS,
                WoodYouDyeItems.BLUE_PLANK_STAIRS, WoodYouDyeItems.CYAN_PLANK_STAIRS, WoodYouDyeItems.LIGHT_BLUE_PLANK_STAIRS,
                WoodYouDyeItems.PURPLE_PLANK_STAIRS, WoodYouDyeItems.PINK_PLANK_STAIRS, WoodYouDyeItems.MAGENTA_PLANK_STAIRS,
                WoodYouDyeItems.BROWN_PLANK_STAIRS, WoodYouDyeItems.WHITE_PLANK_STAIRS, WoodYouDyeItems.LIGHT_GRAY_PLANK_STAIRS,
                WoodYouDyeItems.GRAY_PLANK_STAIRS, WoodYouDyeItems.BLACK_PLANK_STAIRS);

        private static final List<Item> FENCES = List.of(WoodYouDyeItems.RED_PLANK_FENCE, WoodYouDyeItems.ORANGE_PLANK_FENCE,
                WoodYouDyeItems.YELLOW_PLANK_FENCE, WoodYouDyeItems.LIME_PLANK_FENCE, WoodYouDyeItems.GREEN_PLANK_FENCE,
                WoodYouDyeItems.BLUE_PLANK_FENCE, WoodYouDyeItems.CYAN_PLANK_FENCE, WoodYouDyeItems.LIGHT_BLUE_PLANK_FENCE,
                WoodYouDyeItems.PURPLE_PLANK_FENCE, WoodYouDyeItems.PINK_PLANK_FENCE, WoodYouDyeItems.MAGENTA_PLANK_FENCE,
                WoodYouDyeItems.BROWN_PLANK_FENCE, WoodYouDyeItems.WHITE_PLANK_FENCE, WoodYouDyeItems.LIGHT_GRAY_PLANK_FENCE,
                WoodYouDyeItems.GRAY_PLANK_FENCE, WoodYouDyeItems.BLACK_PLANK_FENCE);

        private static final List<Item> FENCE_GATES = List.of(WoodYouDyeItems.RED_PLANK_FENCE_GATE, WoodYouDyeItems.ORANGE_PLANK_FENCE_GATE,
                WoodYouDyeItems.YELLOW_PLANK_FENCE_GATE, WoodYouDyeItems.LIME_PLANK_FENCE_GATE, WoodYouDyeItems.GREEN_PLANK_FENCE_GATE,
                WoodYouDyeItems.BLUE_PLANK_FENCE_GATE, WoodYouDyeItems.CYAN_PLANK_FENCE_GATE, WoodYouDyeItems.LIGHT_BLUE_PLANK_FENCE_GATE,
                WoodYouDyeItems.PURPLE_PLANK_FENCE_GATE, WoodYouDyeItems.PINK_PLANK_FENCE_GATE, WoodYouDyeItems.MAGENTA_PLANK_FENCE_GATE,
                WoodYouDyeItems.BROWN_PLANK_FENCE_GATE, WoodYouDyeItems.WHITE_PLANK_FENCE_GATE, WoodYouDyeItems.LIGHT_GRAY_PLANK_FENCE_GATE,
                WoodYouDyeItems.GRAY_PLANK_FENCE_GATE, WoodYouDyeItems.BLACK_PLANK_FENCE_GATE);

        private static final List<Item> DOORS = List.of(WoodYouDyeItems.RED_PLANK_DOOR, WoodYouDyeItems.ORANGE_PLANK_DOOR,
                WoodYouDyeItems.YELLOW_PLANK_DOOR, WoodYouDyeItems.LIME_PLANK_DOOR, WoodYouDyeItems.GREEN_PLANK_DOOR, WoodYouDyeItems.BLUE_PLANK_DOOR,
                WoodYouDyeItems.CYAN_PLANK_DOOR, WoodYouDyeItems.LIGHT_BLUE_PLANK_DOOR, WoodYouDyeItems.PURPLE_PLANK_DOOR,
                WoodYouDyeItems.PINK_PLANK_DOOR, WoodYouDyeItems.MAGENTA_PLANK_DOOR, WoodYouDyeItems.BROWN_PLANK_DOOR, WoodYouDyeItems.WHITE_PLANK_DOOR,
                WoodYouDyeItems.LIGHT_GRAY_PLANK_DOOR, WoodYouDyeItems.GRAY_PLANK_DOOR, WoodYouDyeItems.BLACK_PLANK_DOOR);

        private static final List<Item> TRAPDOORS = List.of(WoodYouDyeItems.RED_PLANK_TRAPDOOR, WoodYouDyeItems.ORANGE_PLANK_TRAPDOOR,
                WoodYouDyeItems.YELLOW_PLANK_TRAPDOOR, WoodYouDyeItems.LIME_PLANK_TRAPDOOR, WoodYouDyeItems.GREEN_PLANK_TRAPDOOR,
                WoodYouDyeItems.BLUE_PLANK_TRAPDOOR, WoodYouDyeItems.CYAN_PLANK_TRAPDOOR, WoodYouDyeItems.LIGHT_BLUE_PLANK_TRAPDOOR,
                WoodYouDyeItems.PURPLE_PLANK_TRAPDOOR, WoodYouDyeItems.PINK_PLANK_TRAPDOOR, WoodYouDyeItems.MAGENTA_PLANK_TRAPDOOR,
                WoodYouDyeItems.BROWN_PLANK_TRAPDOOR, WoodYouDyeItems.WHITE_PLANK_TRAPDOOR, WoodYouDyeItems.LIGHT_GRAY_PLANK_TRAPDOOR,
                WoodYouDyeItems.GRAY_PLANK_TRAPDOOR, WoodYouDyeItems.BLACK_PLANK_TRAPDOOR);

        private static final List<Item> BUTTONS = List.of(WoodYouDyeItems.RED_PLANK_BUTTON, WoodYouDyeItems.ORANGE_PLANK_BUTTON,
                WoodYouDyeItems.YELLOW_PLANK_BUTTON, WoodYouDyeItems.LIME_PLANK_BUTTON, WoodYouDyeItems.GREEN_PLANK_BUTTON,
                WoodYouDyeItems.BLUE_PLANK_BUTTON, WoodYouDyeItems.CYAN_PLANK_BUTTON, WoodYouDyeItems.LIGHT_BLUE_PLANK_BUTTON,
                WoodYouDyeItems.PURPLE_PLANK_BUTTON, WoodYouDyeItems.PINK_PLANK_BUTTON, WoodYouDyeItems.MAGENTA_PLANK_BUTTON,
                WoodYouDyeItems.BROWN_PLANK_BUTTON, WoodYouDyeItems.WHITE_PLANK_BUTTON, WoodYouDyeItems.LIGHT_GRAY_PLANK_BUTTON,
                WoodYouDyeItems.GRAY_PLANK_BUTTON, WoodYouDyeItems.BLACK_PLANK_BUTTON);

        private static final List<Item> PRESSURE_PLATES = List.of(WoodYouDyeItems.RED_PLANK_PRESSURE_PLATE, WoodYouDyeItems.ORANGE_PLANK_PRESSURE_PLATE,
                WoodYouDyeItems.YELLOW_PLANK_PRESSURE_PLATE, WoodYouDyeItems.LIME_PLANK_PRESSURE_PLATE, WoodYouDyeItems.GREEN_PLANK_PRESSURE_PLATE,
                WoodYouDyeItems.BLUE_PLANK_PRESSURE_PLATE, WoodYouDyeItems.CYAN_PLANK_PRESSURE_PLATE, WoodYouDyeItems.LIGHT_BLUE_PLANK_PRESSURE_PLATE,
                WoodYouDyeItems.PURPLE_PLANK_PRESSURE_PLATE, WoodYouDyeItems.PINK_PLANK_PRESSURE_PLATE, WoodYouDyeItems.MAGENTA_PLANK_PRESSURE_PLATE,
                WoodYouDyeItems.BROWN_PLANK_PRESSURE_PLATE, WoodYouDyeItems.WHITE_PLANK_PRESSURE_PLATE, WoodYouDyeItems.LIGHT_GRAY_PLANK_PRESSURE_PLATE,
                WoodYouDyeItems.GRAY_PLANK_PRESSURE_PLATE, WoodYouDyeItems.BLACK_PLANK_PRESSURE_PLATE);

        private static final List<Item> SIGNS = List.of(WoodYouDyeItems.RED_PLANK_SIGN, WoodYouDyeItems.ORANGE_PLANK_SIGN,
                WoodYouDyeItems.YELLOW_PLANK_SIGN, WoodYouDyeItems.LIME_PLANK_SIGN, WoodYouDyeItems.GREEN_PLANK_SIGN, WoodYouDyeItems.BLUE_PLANK_SIGN,
                WoodYouDyeItems.CYAN_PLANK_SIGN, WoodYouDyeItems.LIGHT_BLUE_PLANK_SIGN, WoodYouDyeItems.PURPLE_PLANK_SIGN,
                WoodYouDyeItems.PINK_PLANK_SIGN, WoodYouDyeItems.MAGENTA_PLANK_SIGN, WoodYouDyeItems.BROWN_PLANK_SIGN, WoodYouDyeItems.WHITE_PLANK_SIGN,
                WoodYouDyeItems.LIGHT_GRAY_PLANK_SIGN, WoodYouDyeItems.GRAY_PLANK_SIGN, WoodYouDyeItems.BLACK_PLANK_SIGN);

        private static final List<Item> HANGING_SIGNS = List.of(WoodYouDyeItems.RED_PLANK_HANGING_SIGN, WoodYouDyeItems.ORANGE_PLANK_HANGING_SIGN,
                WoodYouDyeItems.YELLOW_PLANK_HANGING_SIGN, WoodYouDyeItems.LIME_PLANK_HANGING_SIGN, WoodYouDyeItems.GREEN_PLANK_HANGING_SIGN,
                WoodYouDyeItems.BLUE_PLANK_HANGING_SIGN, WoodYouDyeItems.CYAN_PLANK_HANGING_SIGN, WoodYouDyeItems.LIGHT_BLUE_PLANK_HANGING_SIGN,
                WoodYouDyeItems.PURPLE_PLANK_HANGING_SIGN, WoodYouDyeItems.PINK_PLANK_HANGING_SIGN, WoodYouDyeItems.MAGENTA_PLANK_HANGING_SIGN,
                WoodYouDyeItems.BROWN_PLANK_HANGING_SIGN, WoodYouDyeItems.WHITE_PLANK_HANGING_SIGN, WoodYouDyeItems.LIGHT_GRAY_PLANK_HANGING_SIGN,
                WoodYouDyeItems.GRAY_PLANK_HANGING_SIGN, WoodYouDyeItems.BLACK_PLANK_HANGING_SIGN);
        

        public WYDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        public void buildRecipes(RecipeOutput recipeOutput) {
            RecipeProvider.colorBlockWithDye(recipeOutput, DYES_LIST, PLANKS, "wood_you_dye");
            for(int i = 0; i < 16; i++) {
                RecipeProvider.slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, SLABS.get(i), PLANKS.get(i));
                RecipeProvider.stairBuilder(STAIRS.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.fenceBuilder(FENCES.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.fenceGateBuilder(FENCE_GATES.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.doorBuilder(DOORS.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.trapdoorBuilder(TRAPDOORS.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.buttonBuilder(BUTTONS.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.pressurePlate(recipeOutput, PRESSURE_PLATES.get(i), PLANKS.get(i));
                RecipeProvider.signBuilder(SIGNS.get(i), Ingredient.of(PLANKS.get(i))).unlockedBy(getHasName(PLANKS.get(i)), has(PLANKS.get(i))).save(recipeOutput);
                RecipeProvider.hangingSign(recipeOutput, HANGING_SIGNS.get(i), PLANKS.get(i));
            }
        }

        @Override
        public String getName() {
            return "WoodYouDyeRecipes";
        }
    }
}
