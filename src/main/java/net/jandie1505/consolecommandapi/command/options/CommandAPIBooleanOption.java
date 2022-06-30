package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPIBooleanOptionResult;

public class CommandAPIBooleanOption extends CommandAPIOption {

    public CommandAPIBooleanOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        if(string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false")) {
            return new CommandAPIBooleanOptionResult(Boolean.parseBoolean(string));
        } else {
            return null;
        }
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.BOOLEAN;
    }
}
