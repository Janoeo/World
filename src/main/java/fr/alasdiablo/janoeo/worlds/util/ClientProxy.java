package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.diolib.util.ColorsHelper;
import fr.alasdiablo.janoeo.worlds.init.ModBlocks;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        ColorsHelper.registerFoliageColor(ModBlocks.OAK_LEAVES_APPLE);
    }
}
