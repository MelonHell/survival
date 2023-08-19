package ru.melonhell.survival.platform.minestom;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import ru.melonhell.survival.api.SWrapper;

@ApiStatus.Internal
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = {"handle"})
public class MinestomSCommandSenderWrapper implements MinestomSCommandSender, SWrapper {

    @Getter
    @Accessors(fluent = true)
    @Delegate(types = {Audience.class})
    private final @NotNull CommandSender handle;

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

}
