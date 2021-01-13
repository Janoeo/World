package fr.alasdiablo.janoeo.worlds.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class LogBlock extends RotatedPillarBlock {
    public LogBlock(String registryName) {
        super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)
        );
        this.setRegistryName(registryName);
    }
}
