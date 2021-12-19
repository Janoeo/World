package fr.alasdiablo.janoeo.world.worldgen.placement;

import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import fr.alasdiablo.janoeo.world.worldgen.features.WorldVegetationFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class WorldVegetationPlacements {
    public static final PlacedFeature TREES_CHERRY = createPlacedFeature(Registries.TREES_CHERRY, createTreesCherry());

    private static PlacedFeature createPlacedFeature(String name, PlacedFeature feature) {
        return PlacementUtils.register(RegistryHelper.rl(Registries.MOD_ID, name).toString(), feature);
    }

    private static PlacedFeature createTreesCherry() {
        return WorldVegetationFeatures.TREES_CHERRY.placed(
                PlacementUtils.countExtra(0, 0.05F, 1),
                InSquarePlacement.spread(),
                VegetationPlacements.TREE_THRESHOLD,
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(WorldBlocks.CHERRY_SAPLING.defaultBlockState(), BlockPos.ZERO)),
                BiomeFilter.biome()
        );
    }
}
