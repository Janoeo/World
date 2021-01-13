package fr.alasdiablo.janoeo.worlds.data;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import fr.alasdiablo.janoeo.worlds.init.ModBlocks;
import fr.alasdiablo.janoeo.worlds.init.ModItems;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.util.ResourceLocation;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class ModBlockLootTable extends BlockLootTables {
    private final Map<ResourceLocation, LootTable.Builder> lootTables = Maps.newHashMap();
    private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));
    private static final ILootCondition.IBuilder SHEARS = MatchTool.builder(ItemPredicate.Builder.create().item(Items.SHEARS));
    private static final ILootCondition.IBuilder SILK_TOUCH_OR_SHEARS = SHEARS.alternative(SILK_TOUCH);
    private static final ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS = SILK_TOUCH_OR_SHEARS.inverted();

    @Override
    protected void addTables() {
        this.registerLootTable(ModBlocks.OAK_LEAVES_APPLE, (leaves) -> droppingWithChancesSticksAndApples(leaves, Blocks.OAK_SAPLING, DEFAULT_SAPLING_DROP_RATES).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withSurvivesExplosion(leaves, ItemLootEntry.builder(Items.APPLE)))));
        this.registerLootTable(ModBlocks.CHERRY_LEAVES, (leaves) -> droppingWithChancesAndSticks(leaves, ModBlocks.CHERRY_SAPLING, DEFAULT_SAPLING_DROP_RATES).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withSurvivesExplosion(leaves, ItemLootEntry.builder(ModItems.CHERRY)).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F)))));
        this.registerDropSelfLootTable(ModBlocks.CHERRY_LOG);
        this.registerDropSelfLootTable(ModBlocks.CHERRY_PLANKS);
        this.registerDropSelfLootTable(ModBlocks.CHERRY_SAPLING);
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> lootTable) {
        this.addTables();
        Set<ResourceLocation> set = Sets.newHashSet();

        for (Block block : getKnownBlocks()) {
            ResourceLocation resourcelocation = block.getLootTable();
            if (resourcelocation != LootTables.EMPTY && set.add(resourcelocation)) {
                LootTable.Builder lootTableBuilder = this.lootTables.remove(resourcelocation);
                if (lootTableBuilder != null) {
                    lootTable.accept(resourcelocation, lootTableBuilder);
                }
            }
        }

        if (!this.lootTables.isEmpty()) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.lootTables.keySet());
        }
    }

    @Override
    protected void registerLootTable(Block blockIn, LootTable.Builder table) {
        this.lootTables.put(blockIn.getLootTable(), table);
    }
}
