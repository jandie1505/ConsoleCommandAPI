package net.jandie1505.consolecommandapi.command.commands;

import net.jandie1505.consolecommandapi.command.base.CommandAPICommandBase;
import net.jandie1505.consolecommandapi.command.base.CommandAPIOption;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;

public class CommandAPISubcommand extends CommandAPICommandBase {

    public CommandAPISubcommand(CommandAPICommandExecutor commandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest permissionRequest, CommandAPIOption nextOption) {
        super(commandExecutor, noPermissionExecutor, permissionRequest, nextOption);
    }
}
