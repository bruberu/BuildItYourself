package buildityourself.blocks;

import buildityourself.tiles.BIYTiles;
import buildityourself.tiles.TileEntityBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

public abstract class BlockTileEntityBase<T extends TileEntityBase> extends BlockBase implements ITileEntityProvider {

    protected BlockTileEntityBase(String name, Material material) {
        super(name, material);
        BIYTiles.TILES.add(new BIYTiles.TileEntityEntry(getTileEntityClass(), getRegistryName()));
    }

    public abstract Class<T> getTileEntityClass();
}
