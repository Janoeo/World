package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.Registries;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WorldStructureFeatures {

    public static final ConfiguredStructureFeature<?, ?> OASIS_FEATURE = BuiltinRegistries.register(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
            new ResourceLocation(Registries.MOD_ID, "oasis").toString(),
            WorldStructureFeature.OASIS.configured(NoneFeatureConfiguration.INSTANCE)
    );
}
