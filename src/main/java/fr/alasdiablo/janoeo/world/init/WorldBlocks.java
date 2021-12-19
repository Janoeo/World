package fr.alasdiablo.janoeo.world.init;

import fr.alasdiablo.diolib.registries.RegistryHelper;
import fr.alasdiablo.janoeo.world.World;
import fr.alasdiablo.janoeo.world.block.grower.CherryTreeGrower;
import fr.alasdiablo.janoeo.world.Registries;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.IForgeRegistry;

@SuppressWarnings("unused")
public class WorldBlocks {

    public static final Block OAK_LEAVES_APPLE = createLeaves(Registries.OAK_LEAVES_APPLE);
    public static final Block CHERRY_LEAVES = createLeaves(Registries.CHERRY_LEAVES);
    public static final Block CHERRY_SAPLING = createSapling(new CherryTreeGrower(), Registries.CHERRY_SAPLING);
    public static final Block CHERRY_LOG = createLog(MaterialColor.WOOD, MaterialColor.COLOR_PINK, Registries.CHERRY_LOG);
    public static final Block STRIPPED_CHERRY_LOG = createLog(MaterialColor.COLOR_PINK, MaterialColor.COLOR_PINK, Registries.STRIPPED_CHERRY_LOG);
    public static final Block CHERRY_WOOD = createLog(MaterialColor.WOOD, MaterialColor.COLOR_PINK, Registries.CHERRY_WOOD);
    public static final Block STRIPPED_CHERRY_WOOD = createLog(MaterialColor.COLOR_PINK, MaterialColor.COLOR_PINK, Registries.STRIPPED_CHERRY_WOOD);
    public static final Block CHERRY_PLANKS = createPlanks(MaterialColor.COLOR_PINK, Registries.CHERRY_PLANKS);
    public static final Block CHERRY_DOOR = createDoor(MaterialColor.COLOR_PINK, Registries.CHERRY_DOOR);
    public static final Block CHERRY_BUTTON = createButton(Registries.CHERRY_BUTTON);
    public static final Block CHERRY_PRESSURE_PLATE = createPressurePlate(MaterialColor.COLOR_PINK, Registries.CHERRY_PRESSURE_PLATE);
    public static final Block CHERRY_FENCE = createFence(MaterialColor.COLOR_PINK, Registries.CHERRY_FENCE);
    public static final Block CHERRY_FENCE_GATE = createFenceGate(MaterialColor.COLOR_PINK, Registries.CHERRY_FENCE_GATE);
    public static final Block CHERRY_SLAB = createSlab(MaterialColor.COLOR_PINK, Registries.CHERRY_SLAB);
    public static final Block CHERRY_STAIRS = createStairs(CHERRY_PLANKS, Registries.CHERRY_STAIRS);
    public static final Block CHERRY_TRAPDOOR = createTrapDoor(MaterialColor.COLOR_PINK, Registries.CHERRY_TRAPDOOR);

    public static void initBlock(RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        RegistryHelper.registerBlock(event.getRegistry(),
                                     OAK_LEAVES_APPLE, CHERRY_LEAVES, CHERRY_SAPLING,
                                     CHERRY_LOG, STRIPPED_CHERRY_LOG, CHERRY_WOOD,
                                     STRIPPED_CHERRY_WOOD, CHERRY_PLANKS, CHERRY_DOOR,
                                     CHERRY_BUTTON, CHERRY_PRESSURE_PLATE, CHERRY_FENCE,
                                     CHERRY_FENCE_GATE, CHERRY_SLAB, CHERRY_STAIRS,
                                     CHERRY_TRAPDOOR
        );

        if (FMLEnvironment.dist == Dist.CLIENT) {
            RenderType transparentRenderType = RenderType.cutoutMipped();
            RenderType cutoutRenderType = RenderType.cutout();

            ItemBlockRenderTypes.setRenderLayer(OAK_LEAVES_APPLE, transparentRenderType);
            ItemBlockRenderTypes.setRenderLayer(CHERRY_LEAVES, transparentRenderType);

            ItemBlockRenderTypes.setRenderLayer(CHERRY_SAPLING, cutoutRenderType);

            ItemBlockRenderTypes.setRenderLayer(CHERRY_DOOR, cutoutRenderType);
            ItemBlockRenderTypes.setRenderLayer(CHERRY_TRAPDOOR, cutoutRenderType);
        }
    }

    public static void initItem(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        Item.Properties properties = new Item.Properties().tab(World.GROUP);

        RegistryHelper.registerBlockItem(event.getRegistry(), properties,
                OAK_LEAVES_APPLE, CHERRY_LEAVES, CHERRY_SAPLING,
                CHERRY_LOG, STRIPPED_CHERRY_LOG, CHERRY_WOOD,
                STRIPPED_CHERRY_WOOD, CHERRY_PLANKS, CHERRY_DOOR,
                CHERRY_BUTTON, CHERRY_PRESSURE_PLATE, CHERRY_FENCE,
                CHERRY_FENCE_GATE, CHERRY_SLAB, CHERRY_STAIRS,
                CHERRY_TRAPDOOR
        );
    }

    private static Block createLeaves(String registry) {
        final BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.LEAVES)
                .strength(0.2f)
                .randomTicks()
                .sound(SoundType.GRASS)
                .noOcclusion()
                .isValidSpawn((state, getter, pos, entityType) -> entityType == EntityType.OCELOT || entityType == EntityType.PARROT)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false);
        final Block leaves = new LeavesBlock(properties);
        leaves.setRegistryName(registry);
        return leaves;
    }

    private static Block createSapling(AbstractTreeGrower treeGrower, String registry) {
        final BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.PLANT)
                .noCollission()
                .randomTicks()
                .instabreak()
                .sound(SoundType.GRASS);
        final Block sapling = new SaplingBlock(treeGrower, properties);
        sapling.setRegistryName(registry);
        return sapling;
    }

    private static Block createLog(MaterialColor side, MaterialColor topAndBottom, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, (state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? side : topAndBottom)
                .strength(2.0F)
                .sound(SoundType.WOOD);

        final Block log = new RotatedPillarBlock(properties);
        log.setRegistryName(registry);
        return log;
    }

    private static Block createPlanks(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD);
        final Block planks = new Block(properties);
        planks.setRegistryName(registry);
        return planks;
    }

    private static Block createDoor(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .strength(3.0F)
                .sound(SoundType.WOOD)
                .noOcclusion();
        final Block door = new DoorBlock(properties);
        door.setRegistryName(registry);
        return door;
    }

    private static Block createButton(String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.DECORATION)
                .noCollission()
                .strength(0.5F)
                .sound(SoundType.WOOD);
        final Block button = new WoodButtonBlock(properties);
        button.setRegistryName(registry);
        return button;
    }

    private static Block createPressurePlate(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .noCollission()
                .strength(0.5F)
                .sound(SoundType.WOOD);
        final Block pressurePlate = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING ,properties);
        pressurePlate.setRegistryName(registry);
        return pressurePlate;
    }

    private static Block createFence(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD);
        final Block fence = new FenceBlock(properties);
        fence.setRegistryName(registry);
        return fence;
    }

    private static Block createFenceGate(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD);
        final Block fenceGate = new FenceGateBlock(properties);
        fenceGate.setRegistryName(registry);
        return fenceGate;
    }

    private static Block createSlab(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD);
        final Block slab = new SlabBlock(properties);
        slab.setRegistryName(registry);
        return slab;
    }

    private static Block createStairs(Block planks, String registry) {
        final Block stairs = new StairBlock(planks::defaultBlockState, BlockBehaviour.Properties.copy(planks));
        stairs.setRegistryName(registry);
        return stairs;
    }

    private static Block createTrapDoor(MaterialColor materialColor, String registry) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .of(Material.WOOD, materialColor)
                .strength(3.0F)
                .sound(SoundType.WOOD)
                .noOcclusion()
                .isValidSpawn((state, getter, pos, entityType) -> false);
        final Block trapDoor = new TrapDoorBlock(properties);
        trapDoor.setRegistryName(registry);
        return trapDoor;
    }
}
