package fr.alasdiablo.janoeo.world.data;

import static fr.alasdiablo.janoeo.world.Registries.*;

import fr.alasdiablo.diolib.data.DioBlockStateProvider;
import net.minecraft.data.DataGenerator;

public class WorldBlockStateProvider extends DioBlockStateProvider {

    public WorldBlockStateProvider(DataGenerator gen) {
        super(gen, MOD_ID);
    }

    @Override
    protected void registerStates() {
        this.button(CHERRY_BUTTON);
        this.door(CHERRY_DOOR);
        this.woodenFence(CHERRY_FENCE);
        this.woodenFenceGate(CHERRY_FENCE_GATE);
        this.cubeAll(CHERRY_LEAVES);
        this.pillar(CHERRY_LOG);
        this.pillar(CHERRY_WOOD);
        this.cubeAll(CHERRY_PLANKS);
        this.pressurePlate(CHERRY_PRESSURE_PLATE);
        this.sapling(CHERRY_SAPLING);
        this.slab(CHERRY_SLAB, CHERRY_PLANKS);
        this.stairs(CHERRY_STAIRS);
        this.trapdoor(CHERRY_TRAPDOOR);
        this.cubeAll(OAK_LEAVES_APPLE);
        this.pillar(STRIPPED_CHERRY_LOG);
        this.pillar(STRIPPED_CHERRY_WOOD);
    }
}
