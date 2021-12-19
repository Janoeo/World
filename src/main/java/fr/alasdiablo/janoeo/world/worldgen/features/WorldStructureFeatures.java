package fr.alasdiablo.janoeo.world.worldgen.features;

import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.worldgen.features.feature.OasisFeature;
import fr.alasdiablo.janoeo.world.worldgen.features.feature.TemperateRuinFeature;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldStructureFeatures {

    public static void init(RegistryEvent.Register<StructureFeature<?>> registry) {
        NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig().put(
                OASIS, new StructureFeatureConfiguration(16, 8, 15938630)
        );
        OASIS.setRegistryName(RegistryHelper.rl(Registries.MOD_ID, Registries.OASIS));
        registry.getRegistry().register(OASIS);
        WorldGenerationHelper.addNoiseAffectingFeature(OASIS);

        NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig().put(
                TEMPERATE_RUIN, new StructureFeatureConfiguration(16, 8, 15938630)
        );
        TEMPERATE_RUIN.setRegistryName(RegistryHelper.rl(Registries.MOD_ID, Registries.TEMPERATE_RUIN));
        registry.getRegistry().register(TEMPERATE_RUIN);
        WorldGenerationHelper.addNoiseAffectingFeature(TEMPERATE_RUIN);


        // var structureFeatureRegister = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Registries.MOD_ID);
    }


    public static final StructureFeature<NoneFeatureConfiguration> OASIS = new OasisFeature(NoneFeatureConfiguration.CODEC);
    public static final StructureFeature<NoneFeatureConfiguration> TEMPERATE_RUIN = new TemperateRuinFeature(NoneFeatureConfiguration.CODEC);
    public static final ConfiguredStructureFeature<?, ?> OASIS_FEATURE = BuiltinRegistries.register(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
            RegistryHelper.rl(Registries.MOD_ID, Registries.OASIS).toString(),
            OASIS.configured(NoneFeatureConfiguration.INSTANCE)
    );

    public static final ConfiguredStructureFeature<?, ?> TEMPERATE_RUIN_FEATURE = BuiltinRegistries.register(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
            RegistryHelper.rl(Registries.MOD_ID, Registries.TEMPERATE_RUIN).toString(),
            TEMPERATE_RUIN.configured(NoneFeatureConfiguration.INSTANCE)
    );
}
