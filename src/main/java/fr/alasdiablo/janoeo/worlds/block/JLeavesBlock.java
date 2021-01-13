package fr.alasdiablo.janoeo.worlds.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class JLeavesBlock extends LeavesBlock {
    public JLeavesBlock(String registryName) {
        super(
            AbstractBlock.Properties.create(Material.LEAVES)
                .hardnessAndResistance(0.2F)
                .tickRandomly()
                .sound(SoundType.PLANT)
                .notSolid()
                .setAllowsSpawn(JLeavesBlock::allowsSpawnOnLeaves)
                .setSuffocates(JLeavesBlock::isntSolid)
                .setBlocksVision(JLeavesBlock::isntSolid)
        );
        this.setRegistryName(registryName);
    }

    private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }
}
