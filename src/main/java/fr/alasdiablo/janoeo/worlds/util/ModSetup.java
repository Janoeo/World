package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.janoeo.worlds.init.ModBlocks;
import fr.alasdiablo.janoeo.worlds.world.gen.LeavesGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSetup {

    public ItemGroup janoeoWorldGroup = new ItemGroup("janoeo.world.group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.OAK_LEAVES_APPLE);
        }
    };

    public void init() {
        ForgeRegistries.BIOMES.forEach(biome -> new LeavesGenerator().startWorldGeneration(biome));
    }
}
