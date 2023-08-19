package ru.melonhell.survival.api.commands;

import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.base.SWrapper;

public interface SPermissionHandler extends SWrapper {
    boolean hasPermission(@NotNull String permission);
}
