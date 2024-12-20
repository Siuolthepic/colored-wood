package io.siuolplex.wood_you_dye.forge;

import io.siuolplex.wood_you_dye.WoodYouDyeMain;
import io.siuolplex.wood_you_dye.util.Loader;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;

@Mod(WoodYouDye.ID)
public class WoodYouDye {
    public static final String ID = "wood_you_dye";

    public static final Loader MODLOADER = new ForgeLoader();


    final ModLoadingContext modLoadingContext = ModLoadingContext.get();
    final IEventBus modEventBus = modLoadingContext.getActiveContainer().getEventBus();

    public WoodYouDye() {
        WoodYouDyeMain.init(MODLOADER);
    }

    public static final class ForgeLoader implements Loader {
        @Override
        public String getName() {
            return "neoforge";
        }

    }
}
