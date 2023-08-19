package ru.melonhell.survival.platform.bukkit;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;

record BukkitSWorldWrapper(
        @NotNull World handle
) implements BukkitSWorld, SWrapper {

}
