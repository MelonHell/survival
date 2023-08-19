package ru.melonhell.survival.platform.minestom;

import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SWorld;
import ru.melonhell.survival.api.SWrapper;

public interface MinestomSWorld extends SWorld {

    @Contract("null -> null")
    static MinestomSWorld surv(Instance minestom) {
        if (minestom == null) return null;

        if (minestom instanceof MinestomSWorld survivor)
            return survivor;

        return new MinestomSWorldWrapper(minestom);
    }

    @Contract("null -> null")
    static Instance unsurv(SWorld survivor) {
        if (survivor == null) return null;

        if (survivor instanceof Instance minestom)
            return minestom;

        if (survivor instanceof SWrapper wrapper && wrapper.handle() instanceof Instance minestom)
            return minestom;

        throw new IllegalArgumentException();
    }

}
