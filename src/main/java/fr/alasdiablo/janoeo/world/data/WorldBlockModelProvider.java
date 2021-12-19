package fr.alasdiablo.janoeo.world.data;

import static fr.alasdiablo.janoeo.world.Registries.*;

import fr.alasdiablo.diolib.data.provider.DioBlockModelProvider;
import fr.alasdiablo.diolib.registries.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WorldBlockModelProvider extends DioBlockModelProvider {

    public WorldBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.button(CHERRY_BUTTON, CHERRY_PLANKS);
        this.door(CHERRY_DOOR);
        this.fenceGate(CHERRY_FENCE_GATE, CHERRY_PLANKS);
        this.fence(CHERRY_FENCE, CHERRY_PLANKS);
        this.leaves(CHERRY_LEAVES);
        this.pillar(CHERRY_LOG);
        this.wood(CHERRY_WOOD, CHERRY_LOG);
        this.cubeAll(CHERRY_PLANKS);
        this.pressurePlate(CHERRY_PRESSURE_PLATE, CHERRY_PLANKS);
        this.cross(CHERRY_SAPLING);
        this.slab(CHERRY_SLAB, CHERRY_PLANKS);
        this.stairs(CHERRY_STAIRS, CHERRY_PLANKS);
        this.trapdoor(CHERRY_TRAPDOOR);
        this.berryLeaves(OAK_LEAVES_APPLE, RegistryHelper.rl("minecraft", "block/oak_leaves"), RegistryHelper.rl(MOD_ID, "block/oak_leaves_apple"));
        this.pillar(STRIPPED_CHERRY_LOG);
        this.wood(STRIPPED_CHERRY_WOOD, STRIPPED_CHERRY_LOG);
    }

    private void berryLeaves(String blockNameIn, ResourceLocation textureAllIn, ResourceLocation textureBerry) {
        withExistingParent(blockNameIn, RegistryHelper.rl(MOD_ID, "block/berry_leaves"))
                .texture("all", textureAllIn)
                .texture("berry", textureBerry);
    }

    private void wood(String blockNameIn, String textureNameIn) {
        withExistingParent(blockNameIn, RegistryHelper.rl("minecraft", "block/cube_column"))
                .texture("end", RegistryHelper.rl(this.modid, "block/" + textureNameIn + "_side"))
                .texture("side", RegistryHelper.rl(this.modid, "block/" + textureNameIn + "_side"));

        withExistingParent(blockNameIn + "_horizontal", RegistryHelper.rl("minecraft", "block/cube_column_horizontal"))
                .texture("end", RegistryHelper.rl(this.modid, "block/" + textureNameIn + "_side"))
                .texture("side", RegistryHelper.rl(this.modid, "block/" + textureNameIn + "_side"));
    }
}
