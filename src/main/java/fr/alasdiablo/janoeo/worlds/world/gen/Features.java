package fr.alasdiablo.janoeo.worlds.world.gen;

import com.google.common.collect.ImmutableList;
import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.worlds.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.feature.Features.Placements;

import java.util.Objects;
import java.util.OptionalInt;

public class Features {

    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            "cherry",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.CHERRY_LOG.getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.CHERRY_LEAVES.getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.func_242252_a(3), FeatureSpread.func_242252_a(0), 3),
                            new StraightTrunkPlacer(4, 2, 0),
                            new TwoLayerFeature(1, 0, 1))
                    ).setIgnoreVines().build()
            )
    );
    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_CHERRY = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            "fancy_cherry",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.CHERRY_LOG.getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.CHERRY_LEAVES.getDefaultState()),
                            new FancyFoliagePlacer(FeatureSpread.func_242252_a(3), FeatureSpread.func_242252_a(2), 3),
                            new FancyTrunkPlacer(6, 12, 0),
                            new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    ).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()
            )
    );

    public static void initFeatures() {
        for (int i = 0; i < 4; i++)
            WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                    Objects.requireNonNull(RegistryHelper.setPrefixOnRegistryName(ModBlocks.OAK_LEAVES_APPLE.getRegistryName(), String.valueOf(i))),
                    Blocks.OAK_LEAVES.getDefaultState(),
                    ModBlocks.OAK_LEAVES_APPLE.getDefaultState(),
                    128,
                    60,
                    254
            );

        WorldGenerationHelper.ConfiguredFeatureHelper.register(
                new ResourceLocation("cherry_plain_vegetation"),
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(
                                FANCY_CHERRY.withChance(0.33333334F)
                        ),
                        CHERRY)
                ).withPlacement(Placements.HEIGHTMAP_PLACEMENT)
                        .withPlacement(
                                Placement.COUNT_EXTRA.configure(
                                        new AtSurfaceWithExtraConfig(0, 0.05F, 1)
                                )
                        )
        );
    }
}
