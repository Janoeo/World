package fr.alasdiablo.janoeo.worlds.world.gen;

import fr.alasdiablo.janoeo.util.Utils;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class Features {
    public static void initFeatures() {
        for (int i = 0; i < 4; i++) createBlockGenFeature(
                Utils.setPrefixOnRegistryName(LeavesBlocks.OAK_LEAVES_APPLE.getRegistryName(), String.valueOf(i)),
                Blocks.OAK_LEAVES.getDefaultState(),
                LeavesBlocks.OAK_LEAVES_APPLE.getDefaultState(),
                128,
                60,
                254
        );
    }

    private static void createBlockGenFeature(ResourceLocation name, BlockState replacementBlock, BlockState oreBlock, int count, int bottom, int top) {
        Registry.register(
                WorldGenRegistries.CONFIGURED_FEATURE,
                name,
                Feature.EMERALD_ORE.withConfiguration(
                        new ReplaceBlockConfig(
                                replacementBlock,
                                oreBlock
                        )
                ).withPlacement(
                        Placement.field_242907_l/* RANGE */.configure(
                                new TopSolidRangeConfig(
                                        bottom,
                                        0,
                                        top)
                        )
                ).func_242728_a/* spreadHorizontally */().func_242731_b/* repeat */(count)
        );
    }
}
