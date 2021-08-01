package fr.alasdiablo.janoeo.world.world.feature;

import com.mojang.serialization.Codec;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.world.structure.OasisPieces;
import fr.alasdiablo.janoeo.world.world.structure.TemperateRuinPieces;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.IglooFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.NoiseAffectingStructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TemperateRuinFeature extends StructureFeature<NoneFeatureConfiguration> {

    public TemperateRuinFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
        return FeatureStart::new;
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    public String getFeatureName() {
        return Registries.rl(Registries.TEMPERATE_RUIN).toString();
    }

    public static class FeatureStart extends NoiseAffectingStructureStart<NoneFeatureConfiguration> {
        public FeatureStart(StructureFeature<NoneFeatureConfiguration> p_159888_, ChunkPos p_159889_, int p_159890_, long p_159891_) {
            super(p_159888_, p_159889_, p_159890_, p_159891_);
        }

        public void generatePieces(RegistryAccess registryAccess, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, NoneFeatureConfiguration featureConfiguration, LevelHeightAccessor levelHeightAccessor) {
            int y = chunkGenerator.getBaseHeight(chunkPos.getMinBlockX(), chunkPos.getMinBlockZ(), Heightmap.Types.WORLD_SURFACE_WG, levelHeightAccessor);
            BlockPos blockpos = new BlockPos(chunkPos.getMinBlockX(), y, chunkPos.getMinBlockZ());
            Rotation rotation = Rotation.getRandom(this.random);
            TemperateRuinPieces.addPieces(structureManager, blockpos, rotation, this, random);
        }
    }
}
