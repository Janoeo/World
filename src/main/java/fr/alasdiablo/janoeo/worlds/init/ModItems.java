package fr.alasdiablo.janoeo.worlds.init;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.worlds.World;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModItems {

    public static Item CHERRY
            = new Item(new Item.Properties().group(World.setup.janoeoWorldGroup).food(ModFoods.CHERRY)).setRegistryName(Registries.CHERRY);

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
