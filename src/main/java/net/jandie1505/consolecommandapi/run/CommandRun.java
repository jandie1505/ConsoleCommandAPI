package net.jandie1505.consolecommandapi.run;

import net.jandie1505.consolecommandapi.CommandAPICommandHandler;
import net.jandie1505.consolecommandapi.command.base.CommandAPICommandBase;

import java.util.ArrayList;
import java.util.List;

public class CommandRun {
    private final CommandAPICommandHandler commandHandler;
    private final List<CommandAPICommandBase> commands;
    private boolean success;

    public CommandRun(CommandAPICommandHandler handler) {
        this.commandHandler = handler;
        this.commands = new ArrayList<>();
        this.success = false;
    }

    public void addCommand(CommandAPICommandBase command) {
        this.commands.add(command);
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CommandResult buildResult() {
        return new CommandResult();
    }

    public boolean getSuccess() {
        return this.success;
    }

    public CommandAPICommandBase getCommand() {

    }

    public CommandAPICommandHandler getCommandHandler() {
        return this.commandHandler;
    }
}
