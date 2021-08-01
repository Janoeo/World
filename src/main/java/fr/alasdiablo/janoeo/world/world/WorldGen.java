package fr.alasdiablo.janoeo.world.world;

import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.world.world.gen.WorldFeatures;
import fr.alasdiablo.janoeo.world.world.gen.WorldStructureFeatures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGen {

    private final static Biome.BiomeCategory FOREST = Biome.BiomeCategory.FOREST;
    private final static Biome.BiomeCategory PLAINS = Biome.BiomeCategory.PLAINS;
    private final static Biome.BiomeCategory SWAMP = Biome.BiomeCategory.SWAMP;

    public static void initStructure(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getName() != null) {
            ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)
                    && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.MESA))
            ) {
                generation.addStructureStart(WorldStructureFeatures.OASIS_FEATURE);
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD) &&
                    (
                            BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)
                                    || BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA)
                                    || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)
                    )
            ) {
                generation.addStructureStart(WorldStructureFeatures.TEMPERATE_RUIN_FEATURE);
            }
        }
    }

    public static void initOther() {
        for (Biome biome : ForgeRegistries.BIOMES) {
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
