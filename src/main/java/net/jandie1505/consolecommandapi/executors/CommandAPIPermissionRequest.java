package net.jandie1505.consolecommandapi.executors;

import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;

public interface CommandAPIPermissionRequest {

    boolean hasPermission(CommandAPICommandResult result);

    static CommandAPIPermissionRequest alwaysFail() {
        return result -> false;
    }

    static CommandAPIPermissionRequest alwaysSuccess() {
        return result -> true;
    }

    static CommandAPIPermissionRequest requirePermissionLevel(int level) {
        return result -> result.getSender().getPermissionLevel() >= level;
    }
}
