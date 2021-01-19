package fr.alasdiablo.janoeo.worlds.init;

import fr.alasdiablo.diolib.block.*;
import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.worlds.World;
import fr.alasdiablo.janoeo.worlds.block.trees.CherryTree;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@SuppressWarnings("unused")
public class ModBlocks {

    public static final Block OAK_LEAVES_APPLE = new DioLeavesBlock(Registries.OAK_LEAVES_APPLE);
    public static final Block CHERRY_LEAVES = new DioLeavesBlock(Registries.CHERRY_LEAVES);
    public static final Block CHERRY_SAPLING = new DioSaplingBlock(new CherryTree(), Registries.CHERRY_SAPLING);
    public static final Block CHERRY_LOG = new DioLogBlock(MaterialColor.PINK, Registries.CHERRY_LOG);
    public static final Block STRIPPED_CHERRY_LOG = new DioLogBlock(MaterialColor.PINK, Registries.STRIPPED_CHERRY_LOG);
    public static final Block CHERRY_PLANKS = new DioPlanksBlock(MaterialColor.PINK, Registries.CHERRY_PLANKS);
    public static final Block CHERRY_DOOR = new DioDoorBlock(MaterialColor.PINK, Registries.CHERRY_DOOR);
    public static final Block CHERRY_BUTTON = new DioWoodButtonBlock(Registries.CHERRY_BUTTON);
    public static final Block CHERRY_PRESSURE_PLATE = new DioPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, MaterialColor.PINK, Registries.CHERRY_PRESSURE_PLATE);
    public static final Block CHERRY_FENCE = new DioFenceBlock(CHERRY_PLANKS.getMaterialColor(), Registries.CHERRY_FENCE);
    public static final Block CHERRY_FENCE_GATE = new DioFenceGateBlock(CHERRY_PLANKS.getMaterialColor(), Registries.CHERRY_FENCE_GATE);
    public static final Block CHERRY_SLAB = new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Registries.CHERRY_SLAB);
    public static final Block CHERRY_STAIRS = new StairsBlock(CHERRY_PLANKS::getDefaultState, Block.Properties.from(CHERRY_PLANKS)).setRegistryName(Registries.CHERRY_STAIRS);
    public static final Block CHERRY_TRAPDOOR = new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid().setAllowsSpawn((state, reader, pos, entity) -> false)).setRegistryName(Registries.CHERRY_TRAPDOOR);

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            RegistryHelper.registerBlock(event.getRegistry(),
                    OAK_LEAVES_APPLE, CHERRY_LEAVES, CHERRY_SAPLING,
                    CHERRY_LOG, STRIPPED_CHERRY_LOG, CHERRY_PLANKS,
                    CHERRY_DOOR, CHERRY_BUTTON, CHERRY_PRESSURE_PLATE,
                    CHERRY_FENCE, CHERRY_FENCE_GATE, CHERRY_SLAB,
                    CHERRY_STAIRS, CHERRY_TRAPDOOR
            );

            if (FMLEnvironment.dist == Dist.CLIENT) {
                RenderType transparentRenderType = RenderType.getCutoutMipped();
                RenderType cutoutRenderType = RenderType.getCutout();

                RenderTypeLookup.setRenderLayer(OAK_LEAVES_APPLE, transparentRenderType);
                RenderTypeLookup.setRenderLayer(CHERRY_LEAVES, transparentRenderType);

                RenderTypeLookup.setRenderLayer(CHERRY_SAPLING, cutoutRenderType);

                RenderTypeLookup.setRenderLayer(CHERRY_DOOR, cutoutRenderType);
                RenderTypeLookup.setRenderLayer(CHERRY_TRAPDOOR, cutoutRenderType);
            }
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(World.setup.janoeoWorldGroup);
            RegistryHelper.registerBlockItem(event.getRegistry(), properties,
                    OAK_LEAVES_APPLE, CHERRY_LEAVES, CHERRY_SAPLING,
                    CHERRY_LOG, STRIPPED_CHERRY_LOG, CHERRY_PLANKS,
                    CHERRY_DOOR, CHERRY_BUTTON, CHERRY_PRESSURE_PLATE,
                    CHERRY_FENCE, CHERRY_FENCE_GATE, CHERRY_SLAB,
                    CHERRY_STAIRS, CHERRY_TRAPDOOR
            );
        }
    }
}
