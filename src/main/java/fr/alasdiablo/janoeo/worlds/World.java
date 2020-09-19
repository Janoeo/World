package fr.alasdiablo.janoeo.worlds;

import fr.alasdiablo.janoeo.worlds.util.ClientProxy;
import fr.alasdiablo.janoeo.worlds.util.CommonProxy;
import fr.alasdiablo.janoeo.worlds.util.ModSetup;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Registries.MOD_ID)
public class World {

    public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public static ModSetup setup = new ModSetup();

    public World() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::complete);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
    }

    private void complete(final FMLLoadCompleteEvent event) {
        proxy.init();
    }
}
