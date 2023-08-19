package ru.melonhell.survival.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.melonhell.survival.api.commands.SCommandSender;
import ru.melonhell.survival.api.skins.SSkinProperty;

public interface SPlayer extends SCommandSender, SEntity {

    @NotNull String username();

    @Nullable SSkinProperty skin();

}
