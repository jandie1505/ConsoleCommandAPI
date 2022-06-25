package net.jandie1505.consolecommandapi.executors;

import net.jandie1505.consolecommandapi.run.CommandResult;

public interface CommandAPICommandExecutor {
    void onCommand(CommandResult result);
}
