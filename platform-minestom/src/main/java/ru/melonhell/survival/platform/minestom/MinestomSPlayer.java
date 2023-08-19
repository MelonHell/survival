package ru.melonhell.survival.platform.minestom;

import net.minestom.server.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWrapper;

public interface MinestomSPlayer extends SPlayer, MinestomSCommandSender {

    @Contract("null -> null")
    static MinestomSPlayer surv(Player minestom) {
        if (minestom == null) return null;

        if (minestom instanceof MinestomSPlayer survivor)
            return survivor;

        return new MinestomSPlayerWrapper(minestom);
    }

    @Contract("null -> null")
    static Player unsurv(SPlayer survivor) {
        if (survivor == null) return null;

        if (survivor instanceof Player minestom)
            return minestom;

        if (survivor instanceof SWrapper wrapper && wrapper.handle() instanceof Player minestom)
            return minestom;

        throw new IllegalArgumentException();
    }

}
