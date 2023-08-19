package ru.melonhell.survival.platform.minestom;

import lombok.experimental.UtilityClass;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SPlayer;
import ru.melonhell.survival.api.SWrapper;

@UtilityClass
public class MinestomSPlayerConverter {

    @Contract("null -> null")
    public SPlayer surv(Player minestom) {
        if (minestom == null) return null;

        if (minestom instanceof SPlayer survivor)
            return survivor;

        return new MinestomSPlayerWrapper(minestom);
    }

    @Contract("null -> null")
    public Player unsurv(SPlayer survivor) {
        if (survivor == null) return null;

        if (survivor instanceof Player minestom)
            return minestom;

        if (survivor instanceof SWrapper wrapper && wrapper.handle() instanceof Player minestom)
            return minestom;

        throw new IllegalArgumentException();
    }

}
