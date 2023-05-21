package buildityourself.tiles;

import buildityourself.BuildItYourself;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBase extends TileEntity {
    private String name;

    public TileEntityBase(String name) {
        super();
        this.name = name;
    }

    public ResourceLocation getResourceLocation() {
        return new ResourceLocation(BuildItYourself.MODID, name);
    }
}
