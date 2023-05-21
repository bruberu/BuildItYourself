package buildityourself.blocks;

import net.minecraft.block.material.Material;

public class BlockMachineHull extends BlockBase {
    public final int internalSize;
    protected BlockMachineHull(String name, int internalSize) {
        super(name + "_hull", Material.IRON);
        this.internalSize = internalSize;
    }
}
