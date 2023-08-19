package ru.melonhell.survival.platform.minestom;

import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import net.minestom.server.entity.Player;
import net.minestom.server.entity.PlayerSkin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWorld;
import ru.melonhell.survival.api.SWrapper;
import ru.melonhell.survival.api.skins.SSkinProperty;

import java.util.UUID;

record MinestomSPlayerWrapper(
        @Delegate(types = {Audience.class})
        @NotNull Player handle
) implements SPlayer, SWrapper {

    @Override
    public @NotNull UUID uuid() {
        return handle.getUuid();
    }

    @Override
    public @Nullable SWorld world() {
        return MinestomSWorldConverter.surv(handle.getInstance());
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
