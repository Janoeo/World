package fr.alasdiablo.janoeo.world.worldgen.features;

import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.janoeo.world.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

import java.util.List;

public class WorldVegetationFeatures {
    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> TREES_CHERRY = createTrees(Registries.TREES_CHERRY, createTreesCherry());

    private static ConfiguredFeature<RandomFeatureConfiguration, ?> createTrees(String name, ConfiguredFeature<RandomFeatureConfiguration, ?> configuredFeature) {
        return FeatureUtils.register(RegistryHelper.rl(Registries.MOD_ID, name).toString(), configuredFeature);
    }

    private static ConfiguredFeature<RandomFeatureConfiguration, ?> createTreesCherry() {
        return Feature.RANDOM_SELECTOR.configured(
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(WorldTreeFeatures.FANCY_CHERRY.placed(), 0.33333334F)), WorldTreeFeatures.CHERRY.placed()
                )
        );
    }
}
