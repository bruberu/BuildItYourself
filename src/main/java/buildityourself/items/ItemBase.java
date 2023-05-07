package buildityourself.items;

import buildityourself.BuildItYourself;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class ItemBase extends Item {
    public ItemBase(String name, int stackSize, boolean addToCreative) {
        setRegistryName(name);
        setTranslationKey(name);
        setMaxStackSize(stackSize);

        if (addToCreative) // only add mod-dependent item to creative tab if its associated mod is loaded (checked by subclass)
            setCreativeTab(BuildItYourself.BIY_TAB);

        BIYItems.ITEMS.add(this);
    }

    public ItemBase(String name, int stackSize) {
        this(name, stackSize, true);
    }
    public ItemBase(String name) {
        this(name, 64);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (FMLCommonHandler.instance().getSide() == Side.SERVER)
            return super.getItemStackDisplayName(stack);

        return I18n.format(this.getRegistryName() + ".name");
    }

    public ItemStack getItemStack() {
        return new ItemStack(this);
    }
}
