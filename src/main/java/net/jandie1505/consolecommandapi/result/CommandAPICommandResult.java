package net.jandie1505.consolecommandapi.result;

import java.util.ArrayList;
import java.util.List;

public class CommandAPICommandResult {

    private final List<CommandAPIOptionResult> options;

    public CommandAPICommandResult() {
        this.options = new ArrayList<>();
    }

    public CommandAPICommandResult(List<CommandAPIOptionResult> options) {
        this.options = new ArrayList<>(options);
    }

    public List<CommandAPIOptionResult> getOptions() {
        return List.copyOf(this.options);
    }
}
