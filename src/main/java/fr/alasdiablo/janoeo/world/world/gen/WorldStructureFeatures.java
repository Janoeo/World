package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.janoeo.world.Registries;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WorldStructureFeatures {

    public static final ConfiguredStructureFeature<?, ?> OASIS_FEATURE = BuiltinRegistries.register(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
            Registries.rl(Registries.OASIS).toString(),
            WorldStructureFeature.OASIS.configured(NoneFeatureConfiguration.INSTANCE)
    );

    public static final ConfiguredStructureFeature<?, ?> TEMPERATE_RUIN_FEATURE = BuiltinRegistries.register(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
            Registries.rl(Registries.TEMPERATE_RUIN).toString(),
            WorldStructureFeature.TEMPERATE_RUIN.configured(NoneFeatureConfiguration.INSTANCE)
    );
}
