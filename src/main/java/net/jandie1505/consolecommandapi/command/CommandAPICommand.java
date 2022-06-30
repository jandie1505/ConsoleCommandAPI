package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;
import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;

import java.util.List;
import java.util.Map;

public class CommandAPICommand {
    protected final CommandAPICommandExecutor commandExecutor;
    protected final CommandAPICommandExecutor unsuccessfulExecutor;
    protected final CommandAPICommandExecutor noPermissionExecutor;
    protected final CommandAPIPermissionRequest permissionRequest;
    protected final Map<String, CommandAPICommand> subcommands;
    protected final CommandAPIOption nextOption;

    public CommandAPICommand(CommandAPICommandExecutor commandExecutor, CommandAPICommandExecutor unsuccessfulCommandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest permissionRequest, Map<String, CommandAPICommand> subcommands, CommandAPIOption commandOption) {
        this.subcommands = Map.copyOf(subcommands);
        this.nextOption = commandOption;
        this.commandExecutor = commandExecutor;
        this.unsuccessfulExecutor = unsuccessfulCommandExecutor;
        this.noPermissionExecutor = noPermissionExecutor;
        this.permissionRequest = permissionRequest;
    }

    public void onCommand(String[] cmd, int section, CommandAPICommandRun commandRun) {
        if(this.permissionRequest.hasPermission()) {

            if(cmd.length >= section + 2) {

                boolean subcommand = false;
                for(String command : this.subcommands.keySet()) {

                    if(cmd[section].equalsIgnoreCase(command)) {

                        subcommand = true;
                        this.subcommands.get(command).onCommand(cmd, section + 1, commandRun);

                        break;
                    }

                }

                if(!subcommand) {
                    if(this.nextOption != null) {
                        commandRun = this.nextOption.handleOption(cmd, section + 1, commandRun);

                        if(commandRun.isSuccessful()) {
                            this.commandExecutor.onCommand(commandRun.buildResult());
                        } else {
                            this.unsuccessfulExecutor.onCommand(new CommandAPICommandResult());
                        }
                    } else {
                        this.commandExecutor.onCommand(commandRun.buildResult());
                    }
                }

            } else {
                this.commandExecutor.onCommand(new CommandAPICommandResult());
            }

        } else {
            this.noPermissionExecutor.onCommand(new CommandAPICommandResult());
        }
    }
}
