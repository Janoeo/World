package fr.alasdiablo.janoeo.worlds.util;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.alasdiablo.diolib.data.DioLootTableProvider;
import fr.alasdiablo.janoeo.worlds.data.ModBlockLootTable;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.LootParameterSets;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class DataGenerators {

    @SubscribeEvent
    public static void gatherDate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new DioLootTableProvider(generator, ImmutableList.of(Pair.of(ModBlockLootTable::new, LootParameterSets.BLOCK)), LootParameterSets.BLOCK, "Janoeo World"));
    }
}