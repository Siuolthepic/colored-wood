package io.siuolplex.wood_you_dye.util;

import net.minecraft.util.Identifier;

public class SoulIceIDHandler {
    public static String id = "wood_you_dye";

    public static Identifier idFormatter(String string){
        return new Identifier(id, string);

    }
}
