package fr.alasdiablo.janoeo.world.data;

import fr.alasdiablo.janoeo.world.Registries;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;
import fr.alasdiablo.janoeo.world.init.WorldTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

@MethodsReturnNonnullByDefault
public class WorldBlockTagsProvider extends BlockTagsProvider {
    public WorldBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, Registries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.LEAVES).add(
                WorldBlocks.CHERRY_LEAVES,
                WorldBlocks.OAK_LEAVES_APPLE
        );
        this.tag(WorldTags.Blocks.CHERRY_LOGS).add(
                WorldBlocks.CHERRY_LOG,
                WorldBlocks.STRIPPED_CHERRY_LOG,
                WorldBlocks.CHERRY_WOOD,
                WorldBlocks.STRIPPED_CHERRY_WOOD
        );
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(WorldTags.Blocks.CHERRY_LOGS);
        this.tag(BlockTags.PLANKS).add(WorldBlocks.CHERRY_PLANKS);
        this.tag(BlockTags.SAPLINGS).add(WorldBlocks.CHERRY_SAPLING);
        this.tag(BlockTags.WOODEN_BUTTONS).add(WorldBlocks.CHERRY_BUTTON);
        this.tag(BlockTags.WOODEN_DOORS).add(WorldBlocks.CHERRY_DOOR);
        this.tag(BlockTags.WOODEN_STAIRS).add(WorldBlocks.CHERRY_STAIRS);
        this.tag(BlockTags.WOODEN_SLABS).add(WorldBlocks.CHERRY_SLAB);
        this.tag(BlockTags.WOODEN_FENCES).add(WorldBlocks.CHERRY_FENCE);
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(WorldBlocks.CHERRY_PRESSURE_PLATE);
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(WorldBlocks.CHERRY_TRAPDOOR);
        this.tag(BlockTags.FENCE_GATES).add(WorldBlocks.CHERRY_FENCE_GATE);
    }

    @Override
    public String getName() {
        return "Janoeo World Block Tags";
    }
}
