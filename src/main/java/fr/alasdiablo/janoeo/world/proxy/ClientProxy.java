package fr.alasdiablo.janoeo.world.proxy;

import fr.alasdiablo.diolib.client.ColorsHelper;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        ColorsHelper.registerFoliageColor(WorldBlocks.OAK_LEAVES_APPLE);
    }
}
