package fr.alasdiablo.janoeo.world.world.feature;

import com.mojang.serialization.Codec;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.world.structure.OasisPieces;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class OasisFeature extends StructureFeature<NoneFeatureConfiguration> {

    public OasisFeature(Codec<NoneFeatureConfiguration> p_66121_) {
        super(p_66121_);
    }

    public StructureFeature.StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
        return FeatureStart::new;
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    public String getFeatureName() {
        return new ResourceLocation(Registries.MOD_ID, "oasis").toString();
    }

    public static class FeatureStart extends StructureStart<NoneFeatureConfiguration> {
        public FeatureStart(StructureFeature<NoneFeatureConfiguration> p_159888_, ChunkPos p_159889_, int p_159890_, long p_159891_) {
            super(p_159888_, p_159889_, p_159890_, p_159891_);
        }

        public void generatePieces(RegistryAccess registryAccess, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, NoneFeatureConfiguration featureConfiguration, LevelHeightAccessor levelHeightAccessor) {
            BlockPos blockpos = new BlockPos(chunkPos.getMinBlockX(), 90, chunkPos.getMinBlockZ());
            Rotation rotation = Rotation.getRandom(this.random);
            OasisPieces.addPieces(structureManager, blockpos, rotation, this, this.random);
        }
    }
}