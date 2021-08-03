package fr.alasdiablo.janoeo.world.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.alasdiablo.diolib.data.DioLootTableProvider;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.data.loot.WorldBlockLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class WorldLootTableProvider extends DioLootTableProvider {
    public WorldLootTableProvider(DataGenerator dataGeneratorIn) {
        super(
                dataGeneratorIn,
                ImmutableList.of(Pair.of(WorldBlockLootTables::new, LootContextParamSets.BLOCK)),
                LootContextParamSets.BLOCK,
                Registries.MOD_ID
        );
    }
}
