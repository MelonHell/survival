package ru.melonhell.survival.api.skins;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record SSkinProperty(
        @NotNull String textures,
        @Nullable String signature
) {
    public boolean isSigned() {
        return this.signature != null;
    }
}
