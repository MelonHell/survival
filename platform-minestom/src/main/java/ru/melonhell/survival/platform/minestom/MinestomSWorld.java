package ru.melonhell.survival.platform.minestom;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWorld;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"handle"})
public class MinestomSWorld implements SWorld {

    @Getter
    @Accessors(fluent = true)
    private final @NotNull Instance handle;

    @Contract("null -> null")
    public static SWorld wrap(Instance handle) {
        if (handle == null) return null;

        return new MinestomSWorld(handle);
    }

    @Contract("null -> null")
    public static Instance unwrap(SWorld wrapper) {
        if (wrapper == null) return null;

        return (Instance) wrapper.handle();
    }
}
