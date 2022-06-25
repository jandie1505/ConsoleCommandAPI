package net.jandie1505.consolecommandapi;

import net.jandie1505.consolecommandapi.command.commands.CommandAPICommand;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;
import net.jandie1505.consolecommandapi.run.CommandRun;

import java.util.HashMap;
import java.util.Map;

public class CommandAPICommandHandler {

    private final Map<String, CommandAPICommand> commands;
    private final CommandAPICommandExecutor wrongSyntaxExecutor;
    private final CommandAPICommandExecutor noPermissionExecutor;
    private final CommandAPIPermissionRequest globalPermissionRequest;

    public CommandAPICommandHandler(Map<String, CommandAPICommand> commands, CommandAPICommandExecutor wrongSyntaxExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest globalPermissionRequest) {
        this.commands = new HashMap<>(commands);
        this.wrongSyntaxExecutor = wrongSyntaxExecutor;
        this.noPermissionExecutor = noPermissionExecutor;
        this.globalPermissionRequest = globalPermissionRequest;
    }

    public void onCommand(String[] command) {
        if(this.globalPermissionRequest.hasPermission()) {

            if(command.length >= 1) {
                for(String string : this.getCommands().keySet()) {
                    if(command[0].equalsIgnoreCase(string)) {
                        break;
                    }
                }
            } else {
                this.wrongSyntaxExecutor.onCommand();
            }

        } else {
            this.noPermissionExecutor.onCommand();
        }
    }

    public Map<String, CommandAPICommand> getCommands() {
        return Map.copyOf(commands);
    }
}
