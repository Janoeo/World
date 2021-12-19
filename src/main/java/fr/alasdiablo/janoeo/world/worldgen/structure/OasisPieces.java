package fr.alasdiablo.janoeo.world.worldgen.structure;

import com.google.common.collect.ImmutableMap;
import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.worldgen.features.WorldStructurePieceType;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.Random;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class OasisPieces {
    private static final ResourceLocation STRUCTURE_LOCATION_OASIS = RegistryHelper.rl(Registries.MOD_ID, "desert/oasis");

    private static final Map<ResourceLocation, BlockPos> PIVOTS = ImmutableMap.of(STRUCTURE_LOCATION_OASIS, new BlockPos(7, 4, 7));
    private static final Map<ResourceLocation, BlockPos> OFFSETS = ImmutableMap.of(STRUCTURE_LOCATION_OASIS, new BlockPos(0, -4 , 0));

    public static void addPieces(StructureManager structureManager, BlockPos pos, Rotation rotation, StructurePieceAccessor structurePieceAccessor) {
        structurePieceAccessor.addPiece(new OasisPiece(structureManager, STRUCTURE_LOCATION_OASIS, pos, rotation, 0));
    }

    public static class OasisPiece extends TemplateStructurePiece {

        public OasisPiece(StructureManager structureManager, ResourceLocation resourceLocation, BlockPos pos, Rotation rotation, int p_71248_) {
            super(WorldStructurePieceType.OASIS_STRUCTURE_PIECE, 0, structureManager, resourceLocation, resourceLocation.toString(),
                  makeSettings(rotation, resourceLocation), makePosition(resourceLocation, pos, p_71248_)
            );
        }

        public OasisPiece(StructureManager structureManager, CompoundTag compoundTag) {
            super(WorldStructurePieceType.OASIS_STRUCTURE_PIECE, compoundTag, structureManager, (resourceLocation) -> makeSettings(
                    Rotation.valueOf(compoundTag.getString("Rot")), resourceLocation
            ));
        }

        private static StructurePlaceSettings makeSettings(Rotation rotation, ResourceLocation resourceLocation) {
            return (new StructurePlaceSettings())
                    .setRotation(rotation)
                    .setMirror(Mirror.NONE)
                    .setRotationPivot(OasisPieces.PIVOTS.get(resourceLocation))
                    .addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }

        private static BlockPos makePosition(ResourceLocation resourceLocation, BlockPos pos, int i) {
            return pos.offset(
                    OasisPieces.OFFSETS.get(resourceLocation)
            ).below(i);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext serializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(serializationContext, compoundTag);
            compoundTag.putString("Rot", this.placeSettings.getRotation().name());
        }

        @Override
        public void postProcess(WorldGenLevel worldIn, StructureFeatureManager structureFeatureManager, ChunkGenerator chunkGenerator, Random random, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            // boundingBox.encapsulate(this.template.getBoundingBox(this.placeSettings, this.templatePosition));
            BlockPos prevTemplatePosition = this.templatePosition;
            this.templatePosition = this.templatePosition.offset(0, -4, 0);
            super.postProcess(worldIn, structureFeatureManager, chunkGenerator, random, boundingBox, chunkPos, blockPos);
            this.templatePosition = prevTemplatePosition;
        }

        @Override
        protected void handleDataMarker(String dataMarker, BlockPos pos, ServerLevelAccessor serverLevelAccessor, Random random, BoundingBox boundingBox) {}
    }
}
