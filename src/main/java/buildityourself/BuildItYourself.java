package buildityourself;

import buildityourself.items.BIYItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BuildItYourself.MODID)
public class BuildItYourself {
    public static final String MODID = "buildityourself";
    public static final CreativeTabs BIY_TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return BIYItems.SIDING.getItemStack();
        }
    };

    @SidedProxy(modId = MODID, clientSide = "buildityourself.ClientProxy", serverSide = "buildityourself.CommonProxy")
    public static CommonProxy proxy;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preLoad();
    }
}
