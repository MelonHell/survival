package ru.melonhell.survival.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface SEntity {

    @NotNull UUID uuid();

    @Nullable SWorld world();

}
