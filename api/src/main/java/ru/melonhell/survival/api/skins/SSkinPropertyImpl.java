package ru.melonhell.survival.api.skins;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

record SSkinPropertyImpl(@NotNull String textures, @Nullable String signature) implements SSkinProperty {

}
