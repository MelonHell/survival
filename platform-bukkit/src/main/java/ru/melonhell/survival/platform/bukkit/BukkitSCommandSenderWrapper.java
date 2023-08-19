package ru.melonhell.survival.platform.bukkit;

import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;
import ru.melonhell.survival.api.commands.SCommandSender;

record BukkitSCommandSenderWrapper(
        @Delegate(types = {Audience.class})
        @NotNull CommandSender handle
) implements SCommandSender, SWrapper {

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

}
