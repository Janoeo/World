package fr.alasdiablo.janoeo.world.block.grower;

import fr.alasdiablo.janoeo.world.worldgen.features.WorldTreeFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;

public class CherryTreeGrower extends AbstractTreeGrower {

    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0) {
            return WorldTreeFeatures.FANCY_CHERRY;
        } else {
            return WorldTreeFeatures.CHERRY;
        }
    }
}
