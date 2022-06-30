package net.jandie1505.consolecommandapi.builder;

import net.jandie1505.consolecommandapi.command.CommandAPICommandHandler;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;

public class CommandAPICommandHandlerBuilder {

    private CommandAPICommandExecutor unsuccessfulExecutor;
    private CommandAPICommandExecutor noPermissionExecutor;
    private CommandAPIPermissionRequest permissionRequest;

    public CommandAPICommandHandlerBuilder() {
        this.unsuccessfulExecutor = null;
        this.noPermissionExecutor = null;
        this.permissionRequest = null;
    }

    public CommandAPICommandHandlerBuilder executesCommandNotFound(CommandAPICommandExecutor executor) {
        this.unsuccessfulExecutor = executor;
        return this;
    }

    public CommandAPICommandHandlerBuilder executesNoPermission(CommandAPICommandExecutor executor) {
        this.noPermissionExecutor = executor;
        return this;
    }

    public CommandAPICommandHandlerBuilder setPermissionRequest(CommandAPIPermissionRequest permissionRequest) {
        this.permissionRequest = permissionRequest;
        return this;
    }

    public CommandAPICommandHandler build() {
        return new CommandAPICommandHandler(this.unsuccessfulExecutor, this.noPermissionExecutor, this.permissionRequest);
    }
}
