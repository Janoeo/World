package fr.alasdiablo.janoeo.world.worldgen.features.feature;

import com.mojang.serialization.Codec;
import fr.alasdiablo.janoeo.world.worldgen.structure.OasisPieces;
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
public class OasisFeature extends NoiseAffectingStructureFeature<NoneFeatureConfiguration> {

    public OasisFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec, PieceGeneratorSupplier.simple(PieceGeneratorSupplier.checkForBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG), OasisFeature::generatePieces));
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, PieceGenerator.Context<NoneFeatureConfiguration> configurationContext) {
        var chunkPos = configurationContext.chunkPos();
        var levelHeightAccessor = configurationContext.heightAccessor();
        var chunkGenerator = configurationContext.chunkGenerator();
        var y = chunkGenerator.getBaseHeight(chunkPos.getMinBlockX(), chunkPos.getMinBlockZ(), Heightmap.Types.WORLD_SURFACE_WG, levelHeightAccessor);
        BlockPos blockpos = new BlockPos(chunkPos.getMinBlockX(), y + 4, chunkPos.getMinBlockZ());
        Rotation rotation = Rotation.getRandom(configurationContext.random());
        OasisPieces.addPieces(configurationContext.structureManager(), blockpos, rotation, piecesBuilder);
    }
}
