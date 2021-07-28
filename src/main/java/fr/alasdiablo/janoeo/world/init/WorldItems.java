package fr.alasdiablo.janoeo.world.init;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.world.World;
import fr.alasdiablo.janoeo.world.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class WorldItems {

    public static Item CHERRY
            = new Item(new Item.Properties().tab(World.GROUP).food(WorldFoods.CHERRY)).setRegistryName(Registries.CHERRY);

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            RegistryHelper.registerItem(event.getRegistry(),
                    CHERRY
            );
        }
    }
}
