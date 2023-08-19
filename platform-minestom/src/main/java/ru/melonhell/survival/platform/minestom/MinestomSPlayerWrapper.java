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
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.melonhell.survival.api.SWorld;
import ru.melonhell.survival.api.SWrapper;
import ru.melonhell.survival.api.skins.SSkinProperty;

import java.util.UUID;

@ApiStatus.Internal
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = {"handle"})
public class MinestomSPlayerWrapper implements MinestomSPlayer, SWrapper {

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
        return MinestomSWorld.surv(handle.getInstance());
    }

    @Override
    public @NotNull String username() {
        return handle.getUsername();
    }

    @Override
    public @Nullable SSkinProperty skin() {
        PlayerSkin skin = handle.getSkin();
        if (skin != null) return SSkinProperty.of(skin.textures(), skin.signature());
        return null;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

}
