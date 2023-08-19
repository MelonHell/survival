package ru.melonhell.survival.platform.minestom;

import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;

record MinestomSCommandSenderWrapper(
        @Delegate(types = {Audience.class})
        @NotNull CommandSender handle
) implements MinestomSCommandSender, SWrapper {

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

}
