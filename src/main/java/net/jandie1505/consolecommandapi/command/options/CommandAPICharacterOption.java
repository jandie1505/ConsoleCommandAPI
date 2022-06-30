package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPICharacterOptionResult;

public class CommandAPICharacterOption extends CommandAPIOption {

    public CommandAPICharacterOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        if(string.length() == 1) {
            return new CommandAPICharacterOptionResult(string.charAt(0));
        } else {
            return null;
        }
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.CHARACTER;
    }
}
