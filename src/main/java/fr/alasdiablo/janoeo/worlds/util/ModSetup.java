package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.diolib.gui.GroundItemGroup;
import fr.alasdiablo.diolib.util.BlockHelper;
import fr.alasdiablo.janoeo.worlds.init.ModBlocks;
import fr.alasdiablo.janoeo.worlds.world.gen.LeavesGenerator;
import fr.alasdiablo.janoeo.worlds.world.gen.TreeGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSetup {

    public ItemGroup janoeoWorldGroup = new GroundItemGroup("janoeo.world.group") {
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
        BlockHelper.setFlammability(ModBlocks.OAK_LEAVES_APPLE, BlockHelper.LEAVES_ENCOURAGEMENT, BlockHelper.LEAVES_FLAMMABILITY);
        BlockHelper.setFlammability(ModBlocks.CHERRY_LEAVES, BlockHelper.LEAVES_ENCOURAGEMENT, BlockHelper.LEAVES_FLAMMABILITY);

        BlockHelper.setFlammability(ModBlocks.CHERRY_LOG, BlockHelper.LOG_ENCOURAGEMENT, BlockHelper.LOG_FLAMMABILITY);
        BlockHelper.setFlammability(ModBlocks.STRIPPED_CHERRY_LOG, BlockHelper.LOG_ENCOURAGEMENT, BlockHelper.LOG_FLAMMABILITY);

        BlockHelper.setFlammability(ModBlocks.CHERRY_PLANKS, BlockHelper.PLANKS_ENCOURAGEMENT, BlockHelper.PLANKS_ENCOURAGEMENT);

        BlockHelper.setFlammability(ModBlocks.CHERRY_SLAB, BlockHelper.SLAB_ENCOURAGEMENT, BlockHelper.SLAB_FLAMMABILITY);

        BlockHelper.setFlammability(ModBlocks.CHERRY_STAIRS, BlockHelper.STAIRS_ENCOURAGEMENT, BlockHelper.STAIRS_FLAMMABILITY);
    }

    public void initStrippable() {
        BlockHelper.createStrippableBlock(ModBlocks.CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG);
    }
}
