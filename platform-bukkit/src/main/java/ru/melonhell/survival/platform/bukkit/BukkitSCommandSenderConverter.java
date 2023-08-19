package ru.melonhell.survival.platform.bukkit;

import lombok.experimental.UtilityClass;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SWrapper;
import ru.melonhell.survival.api.commands.SCommandSender;

@UtilityClass
public class BukkitSCommandSenderConverter {

    @Contract("null -> null")
    public SCommandSender surv(CommandSender handle) {
        if (handle == null) return null;

        if (handle instanceof SCommandSender surv)
            return surv;

        if (handle instanceof Player player)
            return BukkitSPlayerConverter.surv(player);

        return new BukkitSCommandSenderWrapper(handle);
    }

    @Contract("null -> null")
    public CommandSender unsurv(SCommandSender surv) {
        if (surv == null) return null;

        if (surv instanceof CommandSender handle)
            return handle;

        if (surv instanceof SWrapper wrapper && wrapper.handle() instanceof CommandSender handle)
            return handle;

        throw new IllegalArgumentException();
    }

}
