package buildityourself.tiles;

import buildityourself.blocks.BlockMachineHull;
import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.screen.ModularScreen;
import com.cleanroommc.modularui.screen.viewport.GuiContext;
import com.cleanroommc.modularui.sync.GuiSyncHandler;
import com.cleanroommc.modularui.sync.SyncHandlers;
import com.cleanroommc.modularui.utils.Alignment;
import com.cleanroommc.modularui.widgets.ItemSlot;
import com.cleanroommc.modularui.widgets.SlotGroupWidget;
import com.cleanroommc.modularui.widgets.layout.Row;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class TileMachiningTable extends TileEntityBase implements IGuiHolder {
    private final ItemStackHandler hullSlot = new ItemStackHandler(1) {
        @Nonnull
        @Override
        public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
            if (stack.getItem() instanceof ItemBlock
                    && ((ItemBlock) stack.getItem()).getBlock() instanceof BlockMachineHull) {
                return super.insertItem(slot, stack, simulate);
            }
            return stack;
        }
    };

    public TileMachiningTable() {
        super("machining_table");
    }

    @Override
    public void buildSyncHandler(GuiSyncHandler guiSyncHandler, EntityPlayer entityPlayer) {
        guiSyncHandler.syncValue("hull", 0, SyncHandlers.itemSlot(this.hullSlot, 0).slotGroup("hull"));
    }

    @Override
    public ModularScreen createClientGui(EntityPlayer player) {
        return ModularScreen.simple("test_gui", this::buildUI);
    }

    public ModularPanel buildUI(GuiContext guiContext) {
        ModularPanel panel = ModularPanel.defaultPanel(guiContext, 176, 306);
        panel.child(IKey.lang("gui.machining_table.title").asWidget().top(5).left(5))
                .bindPlayerInventory()
                .child(new Row().align(Alignment.CenterLeft).top(20).left(5)
                        .child(IKey.lang("gui.machining_table.hull").asWidget().top(4)).child(new ItemSlot().setSynced("hull", 0).leftRel(0.4f)));

        return panel;
    }
}
