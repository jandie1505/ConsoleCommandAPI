package net.jandie1505.consolecommandapi.executors;

import net.jandie1505.consolecommandapi.result.CommandAPICommandResult;

public interface CommandAPICommandExecutor {
    void onCommand(CommandAPICommandResult result);
}
