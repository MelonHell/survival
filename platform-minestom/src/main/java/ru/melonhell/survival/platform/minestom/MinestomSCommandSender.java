package ru.melonhell.survival.platform.minestom;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.commands.SCommandSender;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"handle"})
public class MinestomSCommandSender implements SCommandSender {

    @Getter
    @Accessors(fluent = true)
    @Delegate(types = {Audience.class})
    private final @NotNull CommandSender handle;

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

    @Contract("null -> null")
    public static SCommandSender wrap(CommandSender handle) {
        if (handle == null) return null;

        if (handle instanceof Player player)
            return MinestomSPlayer.wrap(player);

        return new MinestomSCommandSender(handle);
    }

    @Contract("null -> null")
    public static CommandSender unwrap(SCommandSender sender) {
        if (sender == null) return null;

        return (CommandSender) sender.handle();
    }
}
