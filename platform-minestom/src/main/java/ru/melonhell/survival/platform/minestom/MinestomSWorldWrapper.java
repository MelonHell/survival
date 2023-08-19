package ru.melonhell.survival.platform.minestom;

import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;

record MinestomSWorldWrapper(
        @NotNull Instance handle
) implements MinestomSWorld, SWrapper {

}
