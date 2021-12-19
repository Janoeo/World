package fr.alasdiablo.janoeo.world.init;

import fr.alasdiablo.janoeo.world.worldgen.placement.WorldVegetationPlacements;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

public class WorldGenerations {

    public static void onBiomeLoading(BiomeLoadingEvent biomeLoadingEvent) {
        var generation = biomeLoadingEvent.getGeneration();
        var category = biomeLoadingEvent.getCategory();
        var biome = ResourceKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(biomeLoadingEvent.getName()));

        if (category == Biome.BiomeCategory.FOREST || category == Biome.BiomeCategory.PLAINS || category == Biome.BiomeCategory.SWAMP) {
            generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WorldVegetationPlacements.TREES_CHERRY);
        }

//        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY)) {
//            generation.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, WorldStructureFeatures.OASIS_FEATURE);
//        }
    }
}
