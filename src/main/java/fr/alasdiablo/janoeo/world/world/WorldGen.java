package fr.alasdiablo.janoeo.world.world;

import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.world.gen.WorldFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGen {

    private final static Biome.BiomeCategory FOREST = Biome.BiomeCategory.FOREST;
    private final static Biome.BiomeCategory PLAINS = Biome.BiomeCategory.PLAINS;
    private final static Biome.BiomeCategory SWAMP  = Biome.BiomeCategory.SWAMP;


    public static void init() {
        for (Biome biome: ForgeRegistries.BIOMES) {
            final Biome.BiomeCategory category = biome.getBiomeCategory();
            if (category == FOREST || category == PLAINS || category == SWAMP) WorldGenerationHelper.addFeature(
                    biome,
                    WorldFeatures.CHERRY_PLAIN_VEGETATION,
                    GenerationStep.Decoration.VEGETAL_DECORATION
            );

            WorldFeatures.OAK_LEAVES_APPLE.forEach(feature -> WorldGenerationHelper.addFeature(
                    biome,
                    feature.value(),
                    GenerationStep.Decoration.VEGETAL_DECORATION
            ));
        }
    }
}
