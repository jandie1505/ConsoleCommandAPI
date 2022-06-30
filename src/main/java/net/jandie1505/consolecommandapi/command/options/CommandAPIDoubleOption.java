package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPIDoubleOptionResult;

public class CommandAPIDoubleOption extends CommandAPIOption {

    public CommandAPIDoubleOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        try {
            return new CommandAPIDoubleOptionResult(Double.parseDouble(string));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.DOUBLE;
    }
}
