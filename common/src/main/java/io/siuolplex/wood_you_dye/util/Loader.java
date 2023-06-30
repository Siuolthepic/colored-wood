package io.siuolplex.wood_you_dye.util;

import java.nio.file.Path;

public interface Loader {
    String getName();

    boolean getIsClient();

    <T extends Object> T register(T registeredObject, String id);
}
