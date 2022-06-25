package net.jandie1505.consolecommandapi.command.commands;

import net.jandie1505.consolecommandapi.command.base.CommandAPICommandBase;
import net.jandie1505.consolecommandapi.command.base.CommandAPIOption;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;

public class CommandAPICommand extends CommandAPICommandBase {

    public CommandAPICommand(CommandAPICommandExecutor commandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest permissionRequest, CommandAPIOption commandOption) {
        super(commandExecutor, noPermissionExecutor, permissionRequest, commandOption);
    }
}
