package net.jandie1505.consolecommandapi.builder;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.command.CommandAPIStringValueOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;

public class CommandAPIOptionBuilder {

    private final CommandAPIOptionType optionType;
    private boolean required;
    private CommandAPIOption nextOption;

    public CommandAPIOptionBuilder(CommandAPIOptionType optionType) {
        this.optionType = optionType;
        this.required = false;
        this.nextOption = null;
    }

    public CommandAPIOptionBuilder setRequired(boolean required) {
        this.required = required;
        return this;
    }

    public CommandAPIOptionBuilder setNextOption(CommandAPIOption option) {
        this.nextOption = option;
        return this;
    }

    public CommandAPIOption build() {
        if(this.optionType == CommandAPIOptionType.STRING) {
            return new CommandAPIStringValueOption(this.required, this.nextOption);
        } else {
            throw new IllegalArgumentException("OptionType not found");
        }
    }
}
