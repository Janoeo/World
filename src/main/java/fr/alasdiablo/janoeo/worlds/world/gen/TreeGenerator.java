package fr.alasdiablo.janoeo.worlds.world.gen;

import fr.alasdiablo.diolib.world.IWorldGenerator;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;

public class TreeGenerator implements IWorldGenerator {

    private final static Biome.Category FOREST = Biome.Category.FOREST;
    private final static Biome.Category PLAINS = Biome.Category.PLAINS;
    private final static Biome.Category SWAMP  = Biome.Category.SWAMP;

    @Override
    public void startWorldGeneration(Biome biome) {
        final Biome.Category category = biome.getCategory();
        if (category == FOREST || category == PLAINS || category == SWAMP) WorldGenerationHelper.addFeature(
                biome,
                WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(
                        new ResourceLocation("cherry_plain_vegetation")
                ),
                GenerationStage.Decoration.VEGETAL_DECORATION
        );
    }
}
