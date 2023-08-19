package ru.melonhell.survival.platform.bukkit;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import ru.melonhell.survival.api.SWrapper;
import ru.melonhell.survival.api.commands.SCommandSender;

public interface BukkitSCommandSender extends SCommandSender {

    @Contract("null -> null")
    static BukkitSCommandSender surv(CommandSender handle) {
        if (handle == null) return null;

        if (handle instanceof BukkitSCommandSender surv)
            return surv;

        if (handle instanceof Player player)
            return BukkitSPlayer.surv(player);

        return new BukkitSCommandSenderWrapper(handle);
    }

    @Contract("null -> null")
    static CommandSender unsurv(SCommandSender surv) {
        if (surv == null) return null;

        if (surv instanceof CommandSender handle)
            return handle;

        if (surv instanceof SWrapper wrapper && wrapper.handle() instanceof CommandSender handle)
            return handle;

        throw new IllegalArgumentException();
    }

}
