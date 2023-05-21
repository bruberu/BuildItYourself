package buildityourself.tiles;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class BIYTiles {
    public static final List<TileEntityEntry> TILES = new ArrayList<>();

    public static void registerTiles() {
        TILES.forEach(tileEntry -> GameRegistry.registerTileEntity(tileEntry.tileEntityClass, tileEntry.resourceLocation));
    }

    public static class TileEntityEntry {
        public Class<? extends TileEntityBase> tileEntityClass;
        public ResourceLocation resourceLocation;

        public TileEntityEntry(Class<? extends TileEntityBase> tileEntityClass, ResourceLocation resourceLocation) {
            this.tileEntityClass = tileEntityClass;
            this.resourceLocation = resourceLocation;
        }
    }
}
