package ru.melonhell.survival.platform.bukkit;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.bukkit.World;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWorld;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"handle"})
public class BukkitSWorld implements SWorld {

    @Getter
    @Accessors(fluent = true)
    private final @NotNull World handle;

    @Contract("null -> null")
    public static SWorld wrap(World handle) {
        if (handle == null) return null;

        return new BukkitSWorld(handle);
    }

    @Contract("null -> null")
    public static World unwrap(SWorld wrapper) {
        if (wrapper == null) return null;

        return (World) wrapper.handle();
    }
}
