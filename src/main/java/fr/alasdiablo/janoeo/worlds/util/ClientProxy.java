package fr.alasdiablo.janoeo.worlds.util;

import fr.alasdiablo.diolib.util.ColorsHelper;
import fr.alasdiablo.janoeo.worlds.init.ModBlocks;

import java.awt.*;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        ColorsHelper.registerFoliageColor(ModBlocks.OAK_LEAVES_APPLE);
        ColorsHelper.registerFoliageColor(ModBlocks.CHERRY_LEAVES, new Color(0xFF96AE));
    }
}
