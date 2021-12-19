package fr.alasdiablo.janoeo.world.data.loot;

import fr.alasdiablo.diolib.data.loot.BlockLootTable;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import fr.alasdiablo.janoeo.world.init.WorldItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class WorldBlockLootTables extends BlockLootTable {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    @Override
    protected void addTables() {
        this.add(WorldBlocks.OAK_LEAVES_APPLE,
                (leaves) -> createAppleLeavesDrops(leaves, Blocks.OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES)
        );
        this.add(WorldBlocks.CHERRY_LEAVES,
                (leaves) -> createCherryLeavesDrops(leaves, WorldBlocks.CHERRY_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES)
        );
        this.dropSelf(WorldBlocks.CHERRY_LOG);
        this.dropSelf(WorldBlocks.CHERRY_PLANKS);
        this.dropSelf(WorldBlocks.CHERRY_SAPLING);
        this.dropSelf(WorldBlocks.STRIPPED_CHERRY_LOG);
        this.dropSelf(WorldBlocks.CHERRY_BUTTON);
        this.dropSelf(WorldBlocks.CHERRY_STAIRS);
        this.dropSelf(WorldBlocks.CHERRY_PRESSURE_PLATE);
        this.dropSelf(WorldBlocks.CHERRY_FENCE);
        this.dropSelf(WorldBlocks.CHERRY_FENCE_GATE);
        this.dropSelf(WorldBlocks.CHERRY_TRAPDOOR);
        this.add(WorldBlocks.CHERRY_SLAB, WorldBlockLootTables::createSlabItemTable);
        this.add(WorldBlocks.CHERRY_DOOR, WorldBlockLootTables::createDoorTable);
    }

    protected static LootTable.Builder createAppleLeavesDrops(Block leaves, Block sappling, float... chance) {
        return createOakLeavesDrops(leaves, sappling, chance).withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(
                        applyExplosionCondition(leaves, LootItem.lootTableItem(Items.APPLE))
                )
        );
    }

    protected static LootTable.Builder createCherryLeavesDrops(Block leaves, Block sappling, float... chance) {
        return createLeavesDrops(leaves, sappling, chance).withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(
                        applyExplosionCondition(leaves, LootItem.lootTableItem(WorldItems.CHERRY))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                                        0.005F,
                                        0.0055555557F,
                                        0.00625F,
                                        0.008333334F,
                                        0.025F
                                        )
                                )
                )
        );
    }
}
