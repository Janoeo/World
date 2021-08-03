package fr.alasdiablo.janoeo.world;

import fr.alasdiablo.diolib.gui.GroundItemGroup;
import fr.alasdiablo.diolib.util.BlockHelper;
import fr.alasdiablo.janoeo.world.data.*;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import fr.alasdiablo.janoeo.world.init.WorldItems;
import fr.alasdiablo.janoeo.world.world.gen.WorldStructureFeature;
import fr.alasdiablo.janoeo.world.util.ClientProxy;
import fr.alasdiablo.janoeo.world.util.CommonProxy;
import fr.alasdiablo.janoeo.world.world.WorldGen;
import fr.alasdiablo.janoeo.world.world.gen.WorldFeatures;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Registries.MOD_ID)
@MethodsReturnNonnullByDefault
public class World {

    public static final Logger logger = LogManager.getLogger(Registries.MOD_ID);

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
        modBus.addListener(this::gatherData);
        modBus.addGenericListener(Block.class, WorldBlocks::initBlock);
        modBus.addGenericListener(Item.class, WorldBlocks::initItem);
        modBus.addGenericListener(Item.class, WorldItems::init);
        modBus.addGenericListener(StructureFeature.class, WorldStructureFeature::init);
        MinecraftForge.EVENT_BUS.addListener(WorldGen::initStructure);
    }

    private void gatherData(GatherDataEvent event) {
        World.logger.debug("Start data generator");
        final DataGenerator generator = event.getGenerator();
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        World.logger.debug("Add Block State Provider");
        generator.addProvider(new WorldBlockStateProvider(generator));

        World.logger.debug("Add Block State Provider");
        generator.addProvider(new WorldBlockModelProvider(generator, existingFileHelper));

        World.logger.debug("Add Tags Provider");
        final WorldBlockTagsProvider blockTagsProvider = new WorldBlockTagsProvider(generator, existingFileHelper);
        generator.addProvider(blockTagsProvider);
        generator.addProvider(new WorldItemTagsProvider(generator, blockTagsProvider, existingFileHelper));

        World.logger.debug("Add Recipes Provider");
        generator.addProvider(new WorldRecipeProvider(generator));

        World.logger.debug("Add Loot Tables Provider");
        generator.addProvider(new WorldLootTableProvider(generator));
    }

    private void setup(final FMLCommonSetupEvent event) {
        this.initFlammable();
        this.initStrippables();
        WorldGen.initOther();
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
        BlockHelper.createStrippablesBlock(WorldBlocks.CHERRY_WOOD, WorldBlocks.STRIPPED_CHERRY_WOOD);
    }
}
