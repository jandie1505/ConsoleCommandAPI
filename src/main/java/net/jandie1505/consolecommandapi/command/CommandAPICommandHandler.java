package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.command.CommandAPICommand;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;
import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;
import net.jandie1505.consolecommandapi.sender.CommandAPICommandSender;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandAPICommandHandler {

    private final Map<String, CommandAPICommand> commands;
    private final CommandAPICommandExecutor unsuccessfulCommandExecutor;
    private final CommandAPICommandExecutor noPermissionExecutor;
    private final CommandAPIPermissionRequest globalPermissionRequest;

    public CommandAPICommandHandler(CommandAPICommandExecutor unsuccessfulCommandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest globalPermissionRequest) {
        this.commands = new HashMap<>();

        this.unsuccessfulCommandExecutor = Objects.requireNonNullElseGet(unsuccessfulCommandExecutor, () -> result -> {});
        this.noPermissionExecutor = Objects.requireNonNullElseGet(noPermissionExecutor, () -> result -> {});
        this.globalPermissionRequest = Objects.requireNonNullElseGet(globalPermissionRequest, () -> result -> false);
    }

    public void onCommand(CommandAPICommandSender sender, String[] command) {
        if(this.globalPermissionRequest.hasPermission(new CommandAPICommandResult(sender, false))) {

            if(command.length >= 1) {


                for(String string : this.getCommands().keySet()) {

                    if(command[0].equalsIgnoreCase(string)) {
                        this.commands.get(string).onCommand(command, 0, new CommandAPICommandRun(sender));

                        return;
                    }

                }

                this.unsuccessfulCommandExecutor.onCommand(new CommandAPICommandResult(sender, false));

            } else {
                this.unsuccessfulCommandExecutor.onCommand(new CommandAPICommandResult(sender, false));
            }

        } else {
            this.noPermissionExecutor.onCommand(new CommandAPICommandResult(sender, false));
        }
    }

    public void addCommand(String commandName, CommandAPICommand command) {
        this.commands.put(commandName, command);
    }

    public void removeCommand(String commandName) {
        this.commands.remove(commandName);
    }

    public Map<String, CommandAPICommand> getCommands() {
        return Map.copyOf(commands);
    }
}
