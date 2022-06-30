package net.jandie1505.consolecommandapi.executors;

import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;
import net.jandie1505.consolecommandapi.utilities.permissionlevels.CommandAPIPermissionLevelCommandSender;

public interface CommandAPIPermissionRequest {

    boolean hasPermission(CommandAPICommandResult result);

    static CommandAPIPermissionRequest alwaysFail() {
        return result -> false;
    }

    static CommandAPIPermissionRequest alwaysSuccess() {
        return result -> true;
    }

    static CommandAPIPermissionRequest requirePermissionLevel(int level) {
        return result -> (result.getSender() instanceof CommandAPIPermissionLevelCommandSender && ((CommandAPIPermissionLevelCommandSender) result.getSender()).getPermissionLevel() >= level);
    }
}
