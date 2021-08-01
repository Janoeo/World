package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.world.feature.OasisFeature;
import fr.alasdiablo.janoeo.world.world.feature.TemperateRuinFeature;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;

public class WorldStructureFeature {

    public static void init(RegistryEvent.Register<StructureFeature<?>> registry) {
        NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig().put(
                OASIS, new StructureFeatureConfiguration(16, 8, 15938630)
        );
        OASIS.setRegistryName(Registries.rl(Registries.OASIS));
        registry.getRegistry().register(OASIS);
        WorldGenerationHelper.addNoiseAffectingFeature(OASIS);

        NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig().put(
                TEMPERATE_RUIN, new StructureFeatureConfiguration(16, 8, 15938630)
        );
        TEMPERATE_RUIN.setRegistryName(Registries.rl(Registries.TEMPERATE_RUIN));
        registry.getRegistry().register(TEMPERATE_RUIN);
        WorldGenerationHelper.addNoiseAffectingFeature(TEMPERATE_RUIN);
    }


    public static final StructureFeature<NoneFeatureConfiguration> OASIS = new OasisFeature(NoneFeatureConfiguration.CODEC);
    public static final StructureFeature<NoneFeatureConfiguration> TEMPERATE_RUIN = new TemperateRuinFeature(NoneFeatureConfiguration.CODEC);
}
