package fr.alasdiablo.janoeo.world.worldgen.features;

import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.worldgen.structure.OasisPieces;
import fr.alasdiablo.janoeo.world.worldgen.structure.TemperateRuinPieces;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

import java.util.Locale;

public class WorldStructurePieceType {

    public static final StructurePieceType OASIS_STRUCTURE_PIECE = setTemplatePieceId(OasisPieces.OasisPiece::new, RegistryHelper.rl(Registries.MOD_ID, Registries.OASIS));
    public static final StructurePieceType TEMPERATE_RUIN_STRUCTURE_PIECE = setTemplatePieceId(TemperateRuinPieces.TemperateRuinPiece::new, RegistryHelper.rl(Registries.MOD_ID, Registries.TEMPERATE_RUIN));

    private static StructurePieceType setFullContextPieceId(StructurePieceType pieceType, ResourceLocation name) {
        return Registry.register(Registry.STRUCTURE_PIECE, name.toString().toLowerCase(Locale.ROOT), pieceType);
    }

    private static StructurePieceType setPieceId(StructurePieceType.ContextlessType contextlessType, ResourceLocation name) {
        return setFullContextPieceId(contextlessType, name);
    }

    private static StructurePieceType setTemplatePieceId(StructurePieceType.StructureTemplateType templateType, ResourceLocation name) {
        return setFullContextPieceId(templateType, name);
    }
}
