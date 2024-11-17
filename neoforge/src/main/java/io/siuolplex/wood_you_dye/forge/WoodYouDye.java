package io.siuolplex.wood_you_dye.forge;

import io.siuolplex.wood_you_dye.WoodYouDyeMain;
import io.siuolplex.wood_you_dye.util.Loader;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;

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

        @Override
        public boolean getIsClient() {
            return FMLLoader.getDist() == Dist.CLIENT;
        }

        @Override
        public <T> T register(T registeredObject, String id) {
            return registeredObject;
        }
    }
}
