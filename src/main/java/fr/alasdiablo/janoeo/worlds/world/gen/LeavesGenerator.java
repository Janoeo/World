package fr.alasdiablo.janoeo.worlds.world.gen;

import fr.alasdiablo.janoeo.world.OreGenUtils;
import fr.alasdiablo.janoeo.world.gen.IWorldGenerator;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.RecipeProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class LeavesGenerator implements IWorldGenerator {

    @Override
    public void startWorldGeneration() {
        ForgeRegistries.BIOMES.forEach(biome -> {
            this.addFeature(
                    biome,
                    Blocks.OAK_LEAVES.getDefaultState(),
                    LeavesBlocks.OAK_LEAVES_APPLE.getDefaultState(),
                    512,
                    60,
                    254
            );
        });
    }

    private void addFeature(Biome biome, BlockState replamentBlock, BlockState leavesBlock, int count, int bottom, int top) {
        biome.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.EMERALD_ORE.withConfiguration(
                        new ReplaceBlockConfig(
                                replamentBlock,
                                leavesBlock
                        )
                ).withPlacement(
                        Placement.COUNT_RANGE.configure(
                                new CountRangeConfig(
                                        count,
                                        bottom,
                                        0,
                                        top
                                )
                        )
                )
        );
    }
}
