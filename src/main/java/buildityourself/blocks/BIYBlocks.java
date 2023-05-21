package buildityourself.blocks;

import java.util.ArrayList;
import java.util.List;

public class BIYBlocks {
    public static final List<BlockBase> BLOCKS = new ArrayList<>();

    public static BlockBase MACHINING_TABLE;

    public static BlockMachineHull IRON_HULL;

    public static void init() {
        MACHINING_TABLE = new BlockMachiningTable();
        IRON_HULL = new BlockMachineHull("iron", 5);
    }
}
