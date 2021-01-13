package fr.alasdiablo.janoeo.worlds.util;

import com.google.common.collect.Maps;
import fr.alasdiablo.janoeo.worlds.init.ModBlocks;
import fr.alasdiablo.janoeo.worlds.world.gen.LeavesGenerator;
import fr.alasdiablo.janoeo.worlds.world.gen.TreeGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ModSetup {

    public ItemGroup janoeoWorldGroup = new ItemGroup("janoeo.world.group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.OAK_LEAVES_APPLE);
        }
    };

    public void initWorldGen() {
        ForgeRegistries.BIOMES.forEach(biome -> {
                    new LeavesGenerator().startWorldGeneration(biome);
                    new TreeGenerator().startWorldGeneration(biome);
        });
    }

    public void initFlammable() {
        Consumer<Block> registerPlanks = (block) -> {
            FireBlock fireblock = (FireBlock) Blocks.FIRE;
            fireblock.setFireInfo(block, 5, 20);
        };
        Consumer<Block> registerLogs = (block) -> {
            FireBlock fireblock = (FireBlock) Blocks.FIRE;
            fireblock.setFireInfo(block, 5, 5);
        };
        Consumer<Block> registerLeaves = (block) -> {
            FireBlock fireblock = (FireBlock) Blocks.FIRE;
            fireblock.setFireInfo(block, 30, 60);
        };

        registerLeaves.accept(ModBlocks.OAK_LEAVES_APPLE);
        registerLeaves.accept(ModBlocks.CHERRY_LEAVES);

        registerLogs.accept(ModBlocks.CHERRY_LOG);
        registerLogs.accept(ModBlocks.STRIPPED_CHERRY_LOG);

        registerPlanks.accept(ModBlocks.CHERRY_PLANKS);
    }

    public void initStrippable() {
        BiConsumer<Block, Block> register = (log, stripped_log) -> {
            AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
            AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped_log);
        };

        register.accept(ModBlocks.CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG);
    }
}
