package ru.melonhell.survival.platform.minestom;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.entity.Player;
import net.minestom.server.entity.PlayerSkin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWorld;
import ru.melonhell.survival.api.skins.SSkinProperty;

import java.util.UUID;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"handle"})
public class MinestomSPlayer implements SPlayer {

    @Getter
    @Accessors(fluent = true)
    @Delegate(types = {Audience.class})
    private final @NotNull Player handle;

    @Override
    public @NotNull UUID uuid() {
        return handle.getUuid();
    }

    @Override
    public @Nullable SWorld world() {
        return MinestomSWorld.wrap(handle.getInstance());
    }

    @Override
    public @NotNull String username() {
        return handle.getUsername();
    }

    @Override
    public @Nullable SSkinProperty skin() {
        PlayerSkin skin = handle.getSkin();
        if (skin != null) return new SSkinProperty(skin.textures(), skin.signature());
        return null;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

    @Contract("null -> null")
    public static SPlayer wrap(Player handle) {
        if (handle == null) return null;

        return new MinestomSPlayer(handle);
    }

    @Contract("null -> null")
    public static Player unwrap(SPlayer wrapper) {
        if (wrapper == null) return null;

        return (Player) wrapper.handle();
    }
}
