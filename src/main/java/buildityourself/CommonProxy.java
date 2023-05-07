package buildityourself;

import buildityourself.items.BIYItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = BuildItYourself.MODID)
public class CommonProxy {
    public void preLoad() {
        BIYItems.init();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BIYItems.ITEMS.forEach(event.getRegistry()::register);
    }
}
