package net.jandie1505.consolecommandapi.command.subcommand;

import net.jandie1505.consolecommandapi.command.base.CommandAPICommandBase;
import net.jandie1505.consolecommandapi.command.base.CommandAPICommandOption;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;

public class CommandAPISubcommand extends CommandAPICommandBase {

    public CommandAPISubcommand(CommandAPICommandExecutor commandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest permissionRequest, CommandAPICommandOption nextOption) {
        super(commandExecutor, noPermissionExecutor, permissionRequest, nextOption);
    }
}
