package ru.melonhell.survival.platform.bukkit;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWrapper;

@UtilityClass
public class BukkitSPlayerConverter {

    @Contract("null -> null")
    public SPlayer surv(Player handle) {
        if (handle == null) return null;

        if (handle instanceof SPlayer surv)
            return surv;

        return new BukkitSPlayerWrapper(handle);
    }

    @Contract("null -> null")
    public Player unsurv(SPlayer surv) {
        if (surv == null) return null;

        if (surv instanceof Player handle)
            return handle;

        if (surv instanceof SWrapper wrapper && wrapper.handle() instanceof Player handle)
            return handle;

        throw new IllegalArgumentException();
    }

}
