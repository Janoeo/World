package fr.alasdiablo.janoeo.world.init;

import fr.alasdiablo.janoeo.world.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class WorldTags {
    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> CHERRY_LOGS = modTag("cherry_logs");

        private static Tags.IOptionalNamedTag<Block> tag(String modid, String name) {
            return BlockTags.createOptional(new ResourceLocation(modid, name));
        }

        private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
            return tag("forge", name);
        }

        private static Tags.IOptionalNamedTag<Block> modTag(String name) {
            return tag(Registries.MOD_ID, name);
        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> CHERRY_LOGS = modTag("cherry_logs");

        private static Tags.IOptionalNamedTag<Item> tag(String modid, String name) {
            return ItemTags.createOptional(new ResourceLocation(modid, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return tag("forge", name);
        }

        private static Tags.IOptionalNamedTag<Item> modTag(String name) {
            return tag(Registries.MOD_ID, name);
        }
    }
}
