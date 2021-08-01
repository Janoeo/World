package fr.alasdiablo.janoeo.world.world.gen;

import fr.alasdiablo.janoeo.world.world.structure.OasisPieces;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

import java.util.Locale;

public class WorldStructurePieceType {

    private static StructurePieceType setPieceId(StructurePieceType structurePieceType, String name) {
        return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), structurePieceType);
    }

    public static final StructurePieceType OASIS_STRUCTURE_PIECE = setPieceId(OasisPieces.OasisPiece::new, "oasis");

}
