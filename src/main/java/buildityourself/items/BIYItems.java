package buildityourself.items;

import java.util.ArrayList;
import java.util.List;

public class BIYItems {
    public static List<ItemBase> ITEMS = new ArrayList<>();
    public static ItemBase SIDING;

    public static void init() {
        SIDING = new ItemBase("siding");
    }
}
