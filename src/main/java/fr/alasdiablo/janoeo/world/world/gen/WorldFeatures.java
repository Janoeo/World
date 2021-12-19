package fr.alasdiablo.janoeo.world.world.gen;

import com.google.common.collect.ImmutableList;
import fr.alasdiablo.diolib.util.ImmutablePair;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.Objects;
import java.util.OptionalInt;

public class WorldFeatures {

//    private static void register(ResourceLocation registry, ConfiguredFeature<?, ?> configuredFeature) {
//        WorldGenerationHelper.ConfiguredFeatureHelper.register(registry, configuredFeature);
//    }
//
//    public static void init() {
//        register(new ResourceLocation("cherry_tree"), CHERRY_TREE);
//        register(new ResourceLocation("fancy_cherry_tree"), FANCY_CHERRY_TREE);
//        register(new ResourceLocation("cherry_plain_vegetation"), CHERRY_PLAIN_VEGETATION);
//        OAK_LEAVES_APPLE.forEach(
//                feature -> register(feature.key(), feature.value())
//        );
//    }
//
//    public static ConfiguredFeature<TreeConfiguration, ?> CHERRY_TREE = Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(
//                    new SimpleStateProvider(WorldBlocks.CHERRY_LOG.defaultBlockState()),
//                    new StraightTrunkPlacer(4, 2, 0),
//                    new SimpleStateProvider(WorldBlocks.CHERRY_LEAVES.defaultBlockState()),
//                    new SimpleStateProvider(WorldBlocks.CHERRY_SAPLING.defaultBlockState()),
//                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
//                    new TwoLayersFeatureSize(1, 0, 1))
//            ).ignoreVines().build()
//    );
//
//    public static ConfiguredFeature<TreeConfiguration, ?> FANCY_CHERRY_TREE = Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(
//            new SimpleStateProvider(WorldBlocks.CHERRY_LOG.defaultBlockState()),
//            new FancyTrunkPlacer(6, 12, 0),
//            new SimpleStateProvider(WorldBlocks.CHERRY_LEAVES.defaultBlockState()),
//            new SimpleStateProvider(WorldBlocks.CHERRY_SAPLING.defaultBlockState()),
//            new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
//            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
//            ).ignoreVines().build()
//    );
//
//    public static ConfiguredFeature<?, ?> CHERRY_PLAIN_VEGETATION = Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    ImmutableList.of(FANCY_CHERRY_TREE.weighted(0.33333334F)), CHERRY_TREE
//            )
//    ).decorated(MCFeatures.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED)
//            .decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.05F, 1))
//    );
//
//    public static ImmutableList<ImmutablePair<ResourceLocation, ConfiguredFeature<?, ?>>> OAK_LEAVES_APPLE = ImmutableList.of(
//            createOakLeavesAppleConfig(0),
//            createOakLeavesAppleConfig(1),
//            createOakLeavesAppleConfig(2),
//            createOakLeavesAppleConfig(3)
//    );
//
//    private static ImmutablePair<ResourceLocation, ConfiguredFeature<?, ?>> createOakLeavesAppleConfig(int index) {
//        final  ResourceLocation resourceLocation = Objects.requireNonNull(
//                RegistryHelper.setPrefixOnRegistryName(
//                        WorldBlocks.OAK_LEAVES_APPLE.getRegistryName(),
//                        String.valueOf(index)
//                )
//        );
//        final ConfiguredFeature<?, ?> feature = WorldGenerationHelper.ConfiguredFeatureHelper.register(
//                resourceLocation,
//                Feature.REPLACE_SINGLE_BLOCK.configured(
//                        new ReplaceBlockConfiguration(
//                                Blocks.OAK_LEAVES.defaultBlockState(),
//                                WorldBlocks.OAK_LEAVES_APPLE.defaultBlockState()
//                        )
//                ).rangeUniform(
//                        VerticalAnchor.bottom(),
//                        VerticalAnchor.top()
//                ).squared().count(128)
//        );
//
//        return new ImmutablePair<>(resourceLocation, feature);
//    }
//
//    private static class MCFeatures extends net.minecraft.data.worldgen.Features {
//        public static ConfiguredDecorator<?> HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED = Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED;
//
//    }
}
