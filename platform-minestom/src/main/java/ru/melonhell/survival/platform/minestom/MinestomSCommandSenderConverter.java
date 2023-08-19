package ru.melonhell.survival.platform.minestom;

import lombok.experimental.UtilityClass;
import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SWrapper;
import ru.melonhell.survival.api.commands.SCommandSender;

@UtilityClass
public class MinestomSCommandSenderConverter {

    @Contract("null -> null")
    public SCommandSender surv(CommandSender minestom) {
        if (minestom == null) return null;

        if (minestom instanceof SCommandSender survivor)
            return survivor;

        if (minestom instanceof Player player)
            return MinestomSPlayerConverter.surv(player);

        return new MinestomSCommandSenderWrapper(minestom);
    }

    @Contract("null -> null")
    public CommandSender unsurv(SCommandSender survivor) {
        if (survivor == null) return null;

        if (survivor instanceof CommandSender minestom)
            return minestom;

        if (survivor instanceof SWrapper wrapper && wrapper.handle() instanceof CommandSender minestom)
            return minestom;

        throw new IllegalArgumentException();
    }

}
