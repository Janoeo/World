package fr.alasdiablo.janoeo.worlds.world.gen;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.IWorldGenerator;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;

public class LeavesGenerator implements IWorldGenerator {

    @Override
    public void startWorldGeneration(Biome biome) {
        for (int i = 0; i < 4; i++) WorldGenerationHelper.addFeature(
                biome,
                WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(
                    RegistryHelper.setPrefixOnRegistryName(LeavesBlocks.OAK_LEAVES_APPLE.getRegistryName(), String.valueOf(i))
                ),
                GenerationStage.Decoration.VEGETAL_DECORATION
        );
    }
}
