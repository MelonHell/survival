package ru.melonhell.survival.platform.bukkit;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.bukkit.World;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;

@ApiStatus.Internal
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = {"handle"})
public class BukkitSWorldWrapper implements BukkitSWorld, SWrapper {

    @Getter
    @Accessors(fluent = true)
    private final @NotNull World handle;

}
