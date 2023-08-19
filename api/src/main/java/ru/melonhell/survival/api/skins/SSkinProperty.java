package ru.melonhell.survival.api.skins;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SSkinProperty {

    @NotNull String textures();

    @Nullable String signature();

    default boolean isSigned() {
        return signature() != null;
    }

    static SSkinProperty of(@NotNull String textures, @Nullable String signature) {
        return new SSkinPropertyImpl(textures, signature);
    }

}
