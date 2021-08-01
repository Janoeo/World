package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.world.structure.OasisPieces;
import fr.alasdiablo.janoeo.world.world.structure.TemperateRuinPieces;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class WorldStructurePieceType {

    private static StructurePieceType setPieceId(StructurePieceType structurePieceType, ResourceLocation name) {
        return Registry.register(Registry.STRUCTURE_PIECE, name, structurePieceType);
    }

    public static final StructurePieceType OASIS_STRUCTURE_PIECE = setPieceId(OasisPieces.OasisPiece::new, Registries.rl(Registries.OASIS));
    public static final StructurePieceType TEMPERATE_RUIN_STRUCTURE_PIECE = setPieceId(TemperateRuinPieces.TemperateRuinPiece::new, Registries.rl(Registries.TEMPERATE_RUIN));
}
