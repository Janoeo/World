package fr.alasdiablo.janoeo.world.block.grower;

import fr.alasdiablo.janoeo.world.world.gen.WorldFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;

public class CherryTreeGrower extends AbstractTreeGrower {

    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0) {
            return WorldFeatures.FANCY_CHERRY_TREE;
        } else {
            return WorldFeatures.CHERRY_TREE;
        }
    }
}
