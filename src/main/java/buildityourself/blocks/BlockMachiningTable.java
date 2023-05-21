package buildityourself.blocks;

import buildityourself.tiles.TileMachiningTable;
import com.cleanroommc.modularui.manager.GuiInfos;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockMachiningTable extends BlockTileEntityBase<TileMachiningTable> {
    public BlockMachiningTable() {
        super("machining_table", Material.IRON);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMachiningTable();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            GuiInfos.TILE_ENTITY.open(playerIn, worldIn, pos);
        }
        return true;
    }

    @Override
    public Class<TileMachiningTable> getTileEntityClass() {
        return TileMachiningTable.class;
    }
}
