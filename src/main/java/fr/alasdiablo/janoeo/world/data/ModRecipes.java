package fr.alasdiablo.janoeo.world.data;

import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {
    public ModRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(WorldBlocks.CHERRY_PLANKS, 4)
                .requires(WorldBlocks.CHERRY_LOG)
                .unlockedBy("has_cherry_log_block", has(WorldBlocks.CHERRY_LOG))
                .save(consumer,"cherry_planks_from_cherry_log");

        ShapelessRecipeBuilder.shapeless(WorldBlocks.CHERRY_PLANKS, 4)
                .requires(WorldBlocks.STRIPPED_CHERRY_LOG)
                .unlockedBy("has_cherry_log_block", has(WorldBlocks.STRIPPED_CHERRY_LOG))
                .save(consumer, "cherry_planks_from_stripped_cherry_log");

        ShapelessRecipeBuilder.shapeless(WorldBlocks.CHERRY_BUTTON)
                .requires(WorldBlocks.CHERRY_PLANKS)
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_SLAB, 6)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .pattern("CCC")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_STAIRS, 4)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .pattern("C  ")
                .pattern("CC ")
                .pattern("CCC")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_DOOR, 3)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .pattern("CC")
                .pattern("CC")
                .pattern("CC")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_PRESSURE_PLATE)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .pattern("CC")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_FENCE, 3)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("CSC")
                .pattern("CSC")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_FENCE_GATE)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("SCS")
                .pattern("SCS")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(WorldBlocks.CHERRY_TRAPDOOR, 2)
                .define('C', WorldBlocks.CHERRY_PLANKS)
                .pattern("CCC")
                .pattern("CCC")
                .unlockedBy("has_cherry_planks_block", has(WorldBlocks.CHERRY_PLANKS))
                .save(consumer);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return "Janoeo World - Recipes";
    }
}
