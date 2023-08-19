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
public class BukkitSPlayerWrapper implements BukkitSPlayer, SWrapper {

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
        return BukkitSWorld.surv(handle.getWorld());
    }

    @Override
    public @NotNull String username() {
        return handle.getName();
    }

    @Override
    public @Nullable SSkinProperty skin() {
        for (ProfileProperty property : handle.getPlayerProfile().getProperties()) {
            if (property.getName().equals("textures")) {
                return SSkinProperty.of(property.getValue(), property.getSignature());
            }
        }
        return null;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return handle.hasPermission(permission);
    }

}
