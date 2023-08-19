package ru.melonhell.survival.api.commands;

import org.jetbrains.annotations.NotNull;

public interface SPermissionHandler {

    boolean hasPermission(@NotNull String permission);

}
