package fr.alasdiablo.janoeo.world.util;

import fr.alasdiablo.diolib.util.ColorsHelper;
import fr.alasdiablo.janoeo.world.init.WorldBlocks;

import java.awt.Color;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        ColorsHelper.registerFoliageColor(WorldBlocks.OAK_LEAVES_APPLE);
        ColorsHelper.registerFoliageColor(WorldBlocks.CHERRY_LEAVES, new Color(0xFF96AE));
    }
}
