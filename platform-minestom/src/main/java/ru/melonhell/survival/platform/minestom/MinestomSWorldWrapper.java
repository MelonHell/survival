package ru.melonhell.survival.platform.minestom;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;

@ApiStatus.Internal
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = {"handle"})
public class MinestomSWorldWrapper implements MinestomSWorld, SWrapper {

    @Getter
    @Accessors(fluent = true)
    private final @NotNull Instance handle;

}
