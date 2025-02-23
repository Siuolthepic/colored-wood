package io.siuolplex.wood_you_dye.forge;

import io.siuolplex.wood_you_dye.WoodYouDyeMain;
import io.siuolplex.wood_you_dye.util.Loader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@Mod(WoodYouDye.ID)
public class WoodYouDye {
    public static final String ID = "wood_you_dye";

    public static final Loader MODLOADER = new ForgeLoader();

    final ModLoadingContext modLoadingContext = ModLoadingContext.get();
    final IEventBus modEventBus = modLoadingContext.getActiveContainer().getEventBus();

    public WoodYouDye() {
        WoodYouDyeMain.init(MODLOADER);
        modEventBus.register(this);
    }

    public static final class ForgeLoader implements Loader {
        @Override
        public String getName() {
            return "neoforge";
        }
    }

    @SubscribeEvent
    public void addProgArtPack(AddPackFindersEvent event) {
        event.addPackFinders(
                ResourceLocation.fromNamespaceAndPath("wood_you_dye", "resourcepacks/programmer_art"),
                PackType.CLIENT_RESOURCES,
                Component.literal("Wood You Dye Programmer Art"),
                PackSource.DEFAULT,
                false,
                Pack.Position.TOP);

    }
}
