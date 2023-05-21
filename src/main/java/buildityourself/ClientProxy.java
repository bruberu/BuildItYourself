package buildityourself;

import buildityourself.blocks.BIYBlocks;
import buildityourself.items.BIYItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.util.Objects;

public class ClientProxy extends CommonProxy {
    public void preLoad() {
        super.preLoad();

        BIYItems.ITEMS.forEach(ClientProxy::registerModel);
        BIYBlocks.BLOCKS.forEach(block -> registerModel(Item.getItemFromBlock(block)));
    }

    private static void registerModel(Item item) {
        ResourceLocation registryLocation = Objects.requireNonNull(item.getRegistryName());
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(registryLocation, "inventory"));
    }
}
