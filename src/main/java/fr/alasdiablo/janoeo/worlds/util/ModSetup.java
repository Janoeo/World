package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.janoeo.world.gen.IWorldGenerator;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import fr.alasdiablo.janoeo.worlds.world.gen.LeavesGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ModSetup {

    public ItemGroup janoeoWorldGroup = new ItemGroup("janoeo.world.group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(LeavesBlocks.OAK_LEAVES_APPLE);
        }
    };

    public void init() {
        List<IWorldGenerator> generators = new ArrayList<>();
        generators.add(new LeavesGenerator());
        generators.forEach(IWorldGenerator::startWorldGeneration);
    }
}
