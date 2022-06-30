package net.jandie1505.consolecommandapi.utilities.permissionlevels;

import net.jandie1505.consolecommandapi.sender.CommandAPICommandSender;

public interface CommandAPIPermissionLevelCommandSender extends CommandAPICommandSender {

    int getPermissionLevel();

    static CommandAPIPermissionLevelCommandSender maxPermissionSender() {
        return () -> Integer.MAX_VALUE;
    }
}
