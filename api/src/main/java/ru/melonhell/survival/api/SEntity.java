package ru.melonhell.survival.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.melonhell.survival.api.base.SWrapper;

import java.util.UUID;

public interface SEntity extends SWrapper {
    @NotNull UUID uuid();

    @Nullable SWorld world();
}
