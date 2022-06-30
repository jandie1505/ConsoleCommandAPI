package net.jandie1505.consolecommandapi.result;

import net.jandie1505.consolecommandapi.sender.CommandAPICommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandAPICommandResult {

    private final CommandAPICommandSender sender;
    private final List<CommandAPIOptionResult> options;
    private final boolean success;

    public CommandAPICommandResult(CommandAPICommandSender sender, boolean success) {
        this(sender, success, List.of());
    }

    public CommandAPICommandResult(CommandAPICommandSender sender, boolean success, List<CommandAPIOptionResult> options) {
        this.sender = sender;
        this.success = success;
        this.options = List.copyOf(options);
    }

    public List<CommandAPIOptionResult> getOptions() {
        return List.copyOf(this.options);
    }

    public CommandAPICommandSender getSender() {
        return this.sender;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
