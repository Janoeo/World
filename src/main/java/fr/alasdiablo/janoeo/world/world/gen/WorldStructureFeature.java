package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.world.feature.OasisFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;

public class WorldStructureFeature {

    public static void init(RegistryEvent.Register<StructureFeature<?>> registry) {
        NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig().put(
                OASIS, new StructureFeatureConfiguration(25, 10, 15938630)
        );
        OASIS.setRegistryName(new ResourceLocation(Registries.MOD_ID, "oasis"));
        registry.getRegistry().register(OASIS);
        WorldGenerationHelper.addNoiseAffectingFeature(OASIS);
    }


    public static final StructureFeature<NoneFeatureConfiguration> OASIS = new OasisFeature(NoneFeatureConfiguration.CODEC);
}
