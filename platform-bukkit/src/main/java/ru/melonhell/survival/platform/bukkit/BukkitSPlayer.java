package ru.melonhell.survival.platform.bukkit;

import com.destroystokyo.paper.profile.ProfileProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import net.kyori.adventure.audience.Audience;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWorld;
import ru.melonhell.survival.api.skins.SSkinProperty;

import java.util.UUID;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"handle"})
public class BukkitSPlayer implements SPlayer {

    @Getter
    @Accessors(fluent = true)
    @Delegate(types = {Audience.class})
    private final @NotNull Player handle;

    @Override
    public @NotNull UUID uuid() {
        return handle.getUniqueId();
    }

    @Override
    public @NotNull SWorld world() {
        return BukkitSWorld.wrap(handle.getWorld());
    }

    @Override
    public @NotNull String username() {
        return handle.getName();
    }

    @Override
    public @Nullable SSkinProperty skin() {
        for (ProfileProperty property : handle.getPlayerProfile().getProperties()) {
            if (property.getName().equals("textures")) {
                return new SSkinProperty(property.getValue(), property.getSignature());
            }
        }
        return null;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

    @Contract("null -> null")
    public static SPlayer wrap(Player handle) {
        if (handle == null) return null;

        return new BukkitSPlayer(handle);
    }

    @Contract("null -> null")
    public static Player unwrap(SPlayer wrapper) {
        if (wrapper == null) return null;

        return (Player) wrapper.handle();
    }
}
