package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPILongOptionResult;

public class CommandAPILongOption extends CommandAPIOption {

    public CommandAPILongOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        try {
            return new CommandAPILongOptionResult(Long.parseLong(string));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.LONG;
    }
}
