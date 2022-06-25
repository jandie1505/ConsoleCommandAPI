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
}
