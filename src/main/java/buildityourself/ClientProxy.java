package buildityourself;

import buildityourself.items.BIYItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    public void preLoad() {
        super.preLoad();

        BIYItems.ITEMS.forEach(ClientProxy::registerModel);
    }

    private static void registerModel(Item item) {
        ResourceLocation registryLocation = item.getRegistryName();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(registryLocation, "inventory"));
    }
}
