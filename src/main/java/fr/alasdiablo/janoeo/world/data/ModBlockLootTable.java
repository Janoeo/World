package fr.alasdiablo.janoeo.world.data;

import fr.alasdiablo.diolib.data.DioBlockLootTables;

public class ModBlockLootTable extends DioBlockLootTables {
    @Override
    protected void addTables() {

    }
//    private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
//    private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));
//    private static final ILootCondition.IBuilder SHEARS = MatchTool.builder(ItemPredicate.Builder.create().item(Items.SHEARS));
//    private static final ILootCondition.IBuilder SILK_TOUCH_OR_SHEARS = SHEARS.alternative(SILK_TOUCH);
//    private static final ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS = SILK_TOUCH_OR_SHEARS.inverted();
//
//    @Override
//    protected void addTables() {
//        this.registerLootTable(WorldBlocks.OAK_LEAVES_APPLE, (leaves) -> droppingWithChancesSticksAndApples(leaves, Blocks.OAK_SAPLING, DEFAULT_SAPLING_DROP_RATES).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withSurvivesExplosion(leaves, ItemLootEntry.builder(Items.APPLE)))));
//        this.registerLootTable(WorldBlocks.CHERRY_LEAVES, (leaves) -> droppingWithChancesAndSticks(leaves, WorldBlocks.CHERRY_SAPLING, DEFAULT_SAPLING_DROP_RATES).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withSurvivesExplosion(leaves, ItemLootEntry.builder(WorldItems.CHERRY)).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F)))));
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_LOG);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_PLANKS);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_SAPLING);
//        this.registerDropSelfLootTable(WorldBlocks.STRIPPED_CHERRY_LOG);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_BUTTON);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_STAIRS);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_PRESSURE_PLATE);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_FENCE);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_FENCE_GATE);
//        this.registerDropSelfLootTable(WorldBlocks.CHERRY_TRAPDOOR);
//        this.registerLootTable(WorldBlocks.CHERRY_SLAB, ModBlockLootTable::droppingSlab);
//        this.registerLootTable(WorldBlocks.CHERRY_DOOR, ModBlockLootTable::registerDoor);
//    }
}
