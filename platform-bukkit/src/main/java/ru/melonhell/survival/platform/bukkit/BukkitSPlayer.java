package ru.melonhell.survival.platform.bukkit;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWrapper;

public interface BukkitSPlayer extends SPlayer, BukkitSCommandSender {

    @Contract("null -> null")
    static BukkitSPlayer surv(Player handle) {
        if (handle == null) return null;

        if (handle instanceof BukkitSPlayer surv)
            return surv;

        return new BukkitSPlayerWrapper(handle);
    }

    @Contract("null -> null")
    static Player unsurv(SPlayer surv) {
        if (surv == null) return null;

        if (surv instanceof Player handle)
            return handle;

        if (surv instanceof SWrapper wrapper && wrapper.handle() instanceof Player handle)
            return handle;

        throw new IllegalArgumentException();
    }

}
