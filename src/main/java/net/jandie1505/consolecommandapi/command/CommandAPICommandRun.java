package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;

import java.util.ArrayList;
import java.util.List;

public class CommandAPICommandRun {

    private final List<CommandAPIOptionResult> options;
    private boolean success;

    CommandAPICommandRun() {
        this.options = new ArrayList<>();
        this.success = false;
    }

     // SET

    public void addOption(CommandAPIOptionResult option) {
        this.options.add(option);
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // BUILD

    public CommandAPICommandResult buildResult() {
        return new CommandAPICommandResult(this.options);
    }

    // GET

    public List<CommandAPIOptionResult> getOptions() {
        return List.copyOf(this.options);
    }

    public boolean isSuccessful() {
        return this.success;
    }
}
