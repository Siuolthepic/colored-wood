package io.siuolplex.wood_you_dye;

import io.siuolplex.wood_you_dye.registry.WoodYouDyeBlocks;
import io.siuolplex.wood_you_dye.registry.WoodYouDyeItems;
import io.siuolplex.wood_you_dye.util.Loader;

public class WoodYouDyeMain {
    public static Loader LOADER = null;

    public static void init(Loader loader) {
        LOADER = loader;
        if (!LOADER.getName().equals("neoforge")) {
            WoodYouDyeBlocks.init();
            WoodYouDyeItems.init();
        }
    }
}
