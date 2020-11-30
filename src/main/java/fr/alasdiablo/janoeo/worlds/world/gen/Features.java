package fr.alasdiablo.janoeo.worlds.world.gen;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import net.minecraft.block.Blocks;

public class Features {
    public static void initFeatures() {
        for (int i = 0; i < 4; i++) WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                RegistryHelper.setPrefixOnRegistryName(LeavesBlocks.OAK_LEAVES_APPLE.getRegistryName(), String.valueOf(i)),
                Blocks.OAK_LEAVES.getDefaultState(),
                LeavesBlocks.OAK_LEAVES_APPLE.getDefaultState(),
                128,
                60,
                254
        );
    }
}
