package fr.alasdiablo.janoeo.worlds.block.trees;

import fr.alasdiablo.janoeo.worlds.world.gen.Features;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class CherryTree extends Tree {

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0) {
            return Features.FANCY_CHERRY;
        } else {
            return Features.CHERRY;
        }
    }
}
