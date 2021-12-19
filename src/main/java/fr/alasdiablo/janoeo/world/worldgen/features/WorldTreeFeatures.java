package fr.alasdiablo.janoeo.world.worldgen.features;

import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class WorldTreeFeatures {

    public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY = createTree(Registries.CHERRY_TREE, createCherry());
    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_CHERRY = createTree(Registries.FANCY_CHERRY_TREE, createFancyCherry());

    private static ConfiguredFeature<TreeConfiguration, ?> createTree(String name, TreeConfiguration.TreeConfigurationBuilder configuration) {
        var feature = Feature.TREE.configured(configuration.build());
        return FeatureUtils.register(RegistryHelper.rl(Registries.MOD_ID, name).toString(), feature);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createCherry() {
        var configuration = new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(WorldBlocks.CHERRY_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                SimpleStateProvider.simple(WorldBlocks.CHERRY_LEAVES),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
        configuration.ignoreVines();
        return configuration;
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyCherry() {
        var configuration = new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(WorldBlocks.CHERRY_LOG),
                new FancyTrunkPlacer(6, 12, 0),
                SimpleStateProvider.simple(WorldBlocks.CHERRY_LEAVES),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        );
        configuration.ignoreVines();
        return configuration;
    }
}
