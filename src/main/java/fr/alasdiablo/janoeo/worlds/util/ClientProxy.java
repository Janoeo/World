package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        final BlockColors BLOCK_COLORS = Minecraft.getInstance().getBlockColors();
        final ItemColors ITEM_COLORS = Minecraft.getInstance().getItemColors();

        BLOCK_COLORS.register(
                (state, world, pos, tintIndex) -> {
                    if (world != null && pos != null)
                        return BiomeColors.getFoliageColor(world, pos);
                    else
                        return FoliageColors.getDefault();
                },
                LeavesBlocks.OAK_LEAVES_APPLE
        );

        ITEM_COLORS.register(
                (stack, tintIndex) -> {
                    BlockState blockState = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
                    return BLOCK_COLORS.getColor(blockState, null, null, tintIndex);
                },
                LeavesBlocks.OAK_LEAVES_APPLE
        );
    }
}
