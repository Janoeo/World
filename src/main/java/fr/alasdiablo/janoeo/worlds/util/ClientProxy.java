package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.diolib.util.ColorsHelper;
import fr.alasdiablo.janoeo.worlds.block.LeavesBlocks;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        ColorsHelper.registerFoliageColor(LeavesBlocks.OAK_LEAVES_APPLE);
    }
}
