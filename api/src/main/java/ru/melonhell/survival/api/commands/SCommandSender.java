package ru.melonhell.survival.api.commands;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public interface SCommandSender extends SPermissionHandler, Audience {

    default void sendMessage(@NotNull String message) {
        this.sendMessage(Component.text(message));
    }

}
