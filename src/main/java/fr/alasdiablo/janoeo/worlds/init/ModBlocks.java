package fr.alasdiablo.janoeo.worlds.init;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.worlds.World;
import fr.alasdiablo.janoeo.worlds.block.*;
import fr.alasdiablo.janoeo.worlds.block.trees.CherryTree;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
public class ModBlocks {

    public static final Block OAK_LEAVES_APPLE = new JLeavesBlock(Registries.OAK_LEAVES_APPLE);
    public static final Block CHERRY_LOG = new LogBlock(Registries.CHERRY_LOG);
    public static final Block CHERRY_LEAVES = new JLeavesBlock(Registries.CHERRY_LEAVES);
    public static final Block CHERRY_PLANKS = new PlanksBlock(Registries.CHERRY_PLANKS);
    public static final Block CHERRY_DOOR = new JDoorBlock(Registries.CHERRY_DOOR, CHERRY_PLANKS.getMaterialColor());
    public static final Block CHERRY_SAPLING = new JSaplingBlock(new CherryTree(), Registries.CHERRY_SAPLING);

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            RegistryHelper.registerBlock(event.getRegistry(),
                    OAK_LEAVES_APPLE, CHERRY_LOG, CHERRY_LEAVES,
                    CHERRY_DOOR, CHERRY_PLANKS, CHERRY_SAPLING
            );
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(World.setup.janoeoWorldGroup);
            RegistryHelper.registerBlockItem(event.getRegistry(), properties,
                    OAK_LEAVES_APPLE, CHERRY_LOG, CHERRY_LEAVES,
                    CHERRY_DOOR, CHERRY_PLANKS, CHERRY_SAPLING
            );
        }
    }
}
