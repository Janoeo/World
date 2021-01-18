package fr.alasdiablo.janoeo.worlds.data;

import fr.alasdiablo.janoeo.worlds.init.ModBlocks;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import net.minecraft.data.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {
    public ModRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.CHERRY_PLANKS, 4)
                .addIngredient(ModBlocks.CHERRY_LOG)
                .addCriterion("has_cherry_log_block", hasItem(ModBlocks.CHERRY_LOG))
                .build(consumer, new ResourceLocation(Registries.MOD_ID, "cherry_planks_from_cherry_log"));

        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.CHERRY_PLANKS, 4)
                .addIngredient(ModBlocks.STRIPPED_CHERRY_LOG)
                .addCriterion("has_cherry_log_block", hasItem(ModBlocks.STRIPPED_CHERRY_LOG))
                .build(consumer, new ResourceLocation(Registries.MOD_ID, "cherry_planks_from_stripped_cherry_log"));

        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.CHERRY_BUTTON)
                .addIngredient(ModBlocks.CHERRY_PLANKS)
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_SLAB, 6)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .patternLine("CCC")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_STAIRS, 4)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .patternLine("C  ")
                .patternLine("CC ")
                .patternLine("CCC")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_DOOR, 3)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .patternLine("CC")
                .patternLine("CC")
                .patternLine("CC")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_PRESSURE_PLATE)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .patternLine("CC")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_FENCE, 3)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .key('S', Tags.Items.RODS_WOODEN)
                .patternLine("CSC")
                .patternLine("CSC")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_FENCE_GATE)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .key('S', Tags.Items.RODS_WOODEN)
                .patternLine("SCS")
                .patternLine("SCS")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHERRY_TRAPDOOR, 2)
                .key('C', ModBlocks.CHERRY_PLANKS)
                .patternLine("CCC")
                .patternLine("CCC")
                .addCriterion("has_cherry_planks_block", hasItem(ModBlocks.CHERRY_PLANKS))
                .build(consumer);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return "Janoeo World - Recipes";
    }
}
