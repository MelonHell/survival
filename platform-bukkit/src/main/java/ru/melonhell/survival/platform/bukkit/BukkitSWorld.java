package ru.melonhell.survival.platform.bukkit;

import org.bukkit.World;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SWorld;
import ru.melonhell.survival.api.SWrapper;

public interface BukkitSWorld extends SWorld {

    @Contract("null -> null")
    static BukkitSWorld surv(World handle) {
        if (handle == null) return null;

        if (handle instanceof BukkitSWorld surv)
            return surv;

        return new BukkitSWorldWrapper(handle);
    }

    @Contract("null -> null")
    static World unsurv(SWorld surv) {
        if (surv == null) return null;

        if (surv instanceof World handle)
            return handle;

        if (surv instanceof SWrapper wrapper && wrapper.handle() instanceof World handle)
            return handle;

        throw new IllegalArgumentException();
    }

}
