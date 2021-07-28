package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.world.feature.OasisFeature;
import fr.alasdiablo.janoeo.world.world.structure.OasisPieces;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;

import java.util.Locale;

public class WorldStructureFeatures {

    public static void init(RegistryEvent.Register<StructureFeature<?>> registry) {
        NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig().put(
                // OASIS, new StructureFeatureConfiguration(25, 10, 15938630)
                OASIS, new StructureFeatureConfiguration(10, 5, 15938630)
        );
        OASIS.setRegistryName(new ResourceLocation(Registries.MOD_ID, "oasis"));
        registry.getRegistry().register(OASIS);
    }

    private static StructurePieceType setPieceId(StructurePieceType structurePieceType, String name) {
        return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), structurePieceType);
    }

    public static final StructurePieceType OASIS_STRUCTURE_PIECE = setPieceId(OasisPieces.OasisPiece::new, "oasis");

    private static final StructureFeature<NoneFeatureConfiguration> OASIS = new OasisFeature(NoneFeatureConfiguration.CODEC);

    public static final ConfiguredStructureFeature<?, ?> OASIS_FEATURE = BuiltinRegistries.register(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
            new ResourceLocation(Registries.MOD_ID, "oasis").toString(),
            OASIS.configured(NoneFeatureConfiguration.INSTANCE)
    );
}
