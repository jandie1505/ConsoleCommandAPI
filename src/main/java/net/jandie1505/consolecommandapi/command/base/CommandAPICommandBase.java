package net.jandie1505.consolecommandapi.command.base;

import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;

public abstract class CommandAPICommandBase extends CommandAPICommandPart {
    protected final CommandAPICommandExecutor commandExecutor;
    protected final CommandAPICommandExecutor noPermissionExecutor;
    protected final CommandAPIPermissionRequest permissionRequest;
    protected final CommandAPICommandOption nextOption;

    public CommandAPICommandBase(CommandAPICommandExecutor commandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest permissionRequest, CommandAPICommandOption commandOption) {
        this.nextOption = commandOption;
        this.commandExecutor = commandExecutor;
        this.noPermissionExecutor = noPermissionExecutor;
        this.permissionRequest = permissionRequest;
    }

    
}
