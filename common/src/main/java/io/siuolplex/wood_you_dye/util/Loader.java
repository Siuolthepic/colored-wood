package io.siuolplex.wood_you_dye.util;

import java.nio.file.Path;

public interface Loader {
    String getName();

    Path getConfigDir(); // May not be used in this

    boolean getIsClient();


}
