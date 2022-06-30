package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.command.CommandAPICommand;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;
import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;

import java.util.HashMap;
import java.util.Map;

public class CommandAPICommandHandler {

    private final Map<String, CommandAPICommand> commands;
    private final CommandAPICommandExecutor unsuccessfulCommandExecutor;
    private final CommandAPICommandExecutor noPermissionExecutor;
    private final CommandAPIPermissionRequest globalPermissionRequest;

    public CommandAPICommandHandler(Map<String, CommandAPICommand> commands, CommandAPICommandExecutor unsuccessfulCommandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest globalPermissionRequest) {
        this.commands = new HashMap<>(commands);
        this.unsuccessfulCommandExecutor = unsuccessfulCommandExecutor;
        this.noPermissionExecutor = noPermissionExecutor;
        this.globalPermissionRequest = globalPermissionRequest;
    }

    public void onCommand(String[] command) {
        if(this.globalPermissionRequest.hasPermission()) {

            if(command.length >= 1) {


                for(String string : this.getCommands().keySet()) {

                    if(command[0].equalsIgnoreCase(string)) {
                        this.commands.get(string).onCommand(command, 0, new CommandAPICommandRun());

                        return;
                    }

                }

                this.unsuccessfulCommandExecutor.onCommand(new CommandAPICommandResult());

            } else {
                this.unsuccessfulCommandExecutor.onCommand(new CommandAPICommandResult());
            }

        } else {
            this.noPermissionExecutor.onCommand(new CommandAPICommandResult());
        }
    }

    public Map<String, CommandAPICommand> getCommands() {
        return Map.copyOf(commands);
    }
}
