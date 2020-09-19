package fr.alasdiablo.janoeo.worlds.block;

import fr.alasdiablo.janoeo.worlds.World;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@SuppressWarnings("unused")
public class LeavesBlocks {

    @ObjectHolder(Registries.MOD_ID + ":" + Registries.OAK_LEAVES_APPLE)
    public static Block OAK_LEAVES_APPLE;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(
                new LeavesBlock(
                    Block.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid()
                ).setRegistryName(Registries.OAK_LEAVES_APPLE)
            );
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(World.setup.janoeoWorldGroup);
            event.getRegistry().register(new BlockItem(LeavesBlocks.OAK_LEAVES_APPLE, properties).setRegistryName(Registries.OAK_LEAVES_APPLE));
        }
    }
}
