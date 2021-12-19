package fr.alasdiablo.janoeo.world.worldgen.features.feature;

import com.mojang.serialization.Codec;
import fr.alasdiablo.janoeo.world.worldgen.structure.TemperateRuinPieces;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.NoiseAffectingStructureFeature;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TemperateRuinFeature extends NoiseAffectingStructureFeature<NoneFeatureConfiguration> {

    public TemperateRuinFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec, PieceGeneratorSupplier.simple(PieceGeneratorSupplier.checkForBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG), TemperateRuinFeature::generatePieces));
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, PieceGenerator.Context<NoneFeatureConfiguration> configurationContext) {
        var chunkPos = configurationContext.chunkPos();
        var levelHeightAccessor = configurationContext.heightAccessor();
        var chunkGenerator = configurationContext.chunkGenerator();
        var y = chunkGenerator.getBaseHeight(chunkPos.getMinBlockX(), chunkPos.getMinBlockZ(), Heightmap.Types.WORLD_SURFACE_WG, levelHeightAccessor);
        BlockPos blockpos = new BlockPos(chunkPos.getMinBlockX(), y, chunkPos.getMinBlockZ());
        Rotation rotation = Rotation.getRandom(configurationContext.random());
        TemperateRuinPieces.addPieces(configurationContext.structureManager(), blockpos, rotation, piecesBuilder, configurationContext.random());
    }
}
