package net.jandie1505.consolecommandapi.builder;

import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;

public abstract class CommandAPIIntegratedCommandExecutor {

    private final CommandAPICommandExecutor executor;
    private final CommandAPICommandExecutor unsuccessfulExecutor;
    private final CommandAPICommandExecutor noPermissionExecutor;

    public CommandAPIIntegratedCommandExecutor() {
        this.executor = this::onCommand;
        this.unsuccessfulExecutor = this::onUnsuccessfulCommand;
        this.noPermissionExecutor = this::onNoPermission;
    }

    public abstract void onCommand(CommandAPICommandResult result);

    public abstract void onUnsuccessfulCommand(CommandAPICommandResult result);

    public abstract void onNoPermission(CommandAPICommandResult result);

    CommandAPICommandExecutor getExecutor() {
        return this.executor;
    }

    CommandAPICommandExecutor getUnsuccessfulExecutor() {
        return this.unsuccessfulExecutor;
    }

    CommandAPICommandExecutor getNoPermissionExecutor() {
        return this.noPermissionExecutor;
    }
}
