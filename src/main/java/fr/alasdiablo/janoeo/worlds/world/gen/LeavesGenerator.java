package fr.alasdiablo.janoeo.worlds.world.gen;

import fr.alasdiablo.janoeo.util.Utils;
import fr.alasdiablo.janoeo.world.OreGenUtils;
import fr.alasdiablo.janoeo.world.gen.IWorldGenerator;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;

public class LeavesGenerator implements IWorldGenerator {

    @Override
    public void startWorldGeneration(Biome biome) {
        for (int i = 0; i < 4; i++) OreGenUtils.addFeatureToBiome(
                biome,
                WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(
                    Utils.setPrefixOnRegistryName(LeavesBlocks.OAK_LEAVES_APPLE.getRegistryName(), String.valueOf(i))
                ),
                GenerationStage.Decoration.VEGETAL_DECORATION
        );
    }
}
