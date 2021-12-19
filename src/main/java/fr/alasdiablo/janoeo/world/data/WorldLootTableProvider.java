package fr.alasdiablo.janoeo.world.data;

import com.mojang.datafixers.util.Pair;
import fr.alasdiablo.diolib.data.provider.DioLootTableProvider;
import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.data.loot.WorldBlockLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class WorldLootTableProvider extends DioLootTableProvider {
    public WorldLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn, Registries.MOD_ID);
    }

    @Override
    public void registerAdvancements() {
        this.addLootTable(Pair.of(WorldBlockLootTables::new, LootContextParamSets.BLOCK));
    }
}
