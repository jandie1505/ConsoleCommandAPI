package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPICommandRun;
import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPIStringOptionResult;

public class CommandAPIStringOption extends CommandAPIOption {

    public CommandAPIStringOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        return new CommandAPIStringOptionResult(string);
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.STRING;
    }
}
