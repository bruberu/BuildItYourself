package buildityourself;

import buildityourself.blocks.BIYBlocks;
import buildityourself.items.BIYItems;
import buildityourself.tiles.BIYTiles;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = BuildItYourself.MODID)
public class CommonProxy {
    public void preLoad() {
        BIYItems.init();
        BIYBlocks.init();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BIYItems.ITEMS.forEach(event.getRegistry()::register);

        BIYBlocks.BLOCKS.forEach(block -> block.getItemBlock().ifPresent(event.getRegistry()::register));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BIYBlocks.BLOCKS.forEach(event.getRegistry()::register);
        BIYTiles.registerTiles();
    }
}
