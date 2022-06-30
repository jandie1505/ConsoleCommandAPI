package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPIIntegerOptionResult;

public class CommandAPIIntegerOption extends CommandAPIOption {

    public CommandAPIIntegerOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        try {
            return new CommandAPIIntegerOptionResult(Integer.parseInt(string));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.INTEGER;
    }
}
