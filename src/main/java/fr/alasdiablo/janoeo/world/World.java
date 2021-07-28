package fr.alasdiablo.janoeo.world;

import fr.alasdiablo.diolib.gui.GroundItemGroup;
import fr.alasdiablo.diolib.util.BlockHelper;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import fr.alasdiablo.janoeo.world.init.WorldItems;
import fr.alasdiablo.janoeo.world.util.ClientProxy;
import fr.alasdiablo.janoeo.world.util.CommonProxy;
import fr.alasdiablo.janoeo.world.world.WorldGen;
import fr.alasdiablo.janoeo.world.world.gen.WorldFeatures;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Registries.MOD_ID)
@MethodsReturnNonnullByDefault
public class World {

    public static final CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public static final CreativeModeTab GROUP = new GroundItemGroup("janoeo.world.group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WorldBlocks.OAK_LEAVES_APPLE);
        }
    };

    public World() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::complete);
        modBus.addListener(this::initFeatures);
        modBus.addGenericListener(Block.class, WorldBlocks::initBlock);
        modBus.addGenericListener(Item.class, WorldBlocks::initItem);
        // modBus.addGenericListener(Item.class, WorldItems::init);
    }

    private void setup(final FMLCommonSetupEvent event) {
        this.initFlammable();
        this.initStrippables();
        WorldGen.init();
    }

    private void initFeatures(RegistryEvent.NewRegistry e) {
        WorldFeatures.init();
    }

    private void complete(final FMLLoadCompleteEvent event) {
        PROXY.init();
    }

    private void initFlammable() {
        BlockHelper.setFlammability(WorldBlocks.OAK_LEAVES_APPLE, BlockHelper.LEAVES_ENCOURAGEMENT, BlockHelper.LEAVES_FLAMMABILITY);
        BlockHelper.setFlammability(WorldBlocks.CHERRY_LEAVES, BlockHelper.LEAVES_ENCOURAGEMENT, BlockHelper.LEAVES_FLAMMABILITY);

        BlockHelper.setFlammability(WorldBlocks.CHERRY_LOG, BlockHelper.LOG_ENCOURAGEMENT, BlockHelper.LOG_FLAMMABILITY);
        BlockHelper.setFlammability(WorldBlocks.STRIPPED_CHERRY_LOG, BlockHelper.LOG_ENCOURAGEMENT, BlockHelper.LOG_FLAMMABILITY);

        BlockHelper.setFlammability(WorldBlocks.CHERRY_PLANKS, BlockHelper.PLANKS_ENCOURAGEMENT, BlockHelper.PLANKS_ENCOURAGEMENT);

        BlockHelper.setFlammability(WorldBlocks.CHERRY_SLAB, BlockHelper.SLAB_ENCOURAGEMENT, BlockHelper.SLAB_FLAMMABILITY);

        BlockHelper.setFlammability(WorldBlocks.CHERRY_STAIRS, BlockHelper.STAIRS_ENCOURAGEMENT, BlockHelper.STAIRS_FLAMMABILITY);
    }

    private void initStrippables() {
        BlockHelper.createStrippablesBlock(WorldBlocks.CHERRY_LOG, WorldBlocks.STRIPPED_CHERRY_LOG);
    }
}
