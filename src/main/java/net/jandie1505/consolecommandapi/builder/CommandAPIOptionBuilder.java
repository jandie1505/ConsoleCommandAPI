package net.jandie1505.consolecommandapi.builder;

import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.command.options.*;
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
            return new CommandAPIStringOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.INTEGER) {
            return new CommandAPIIntegerOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.LONG) {
            return new CommandAPILongOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.FLOAT) {
            return new CommandAPIFloatOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.DOUBLE) {
            return new CommandAPIDoubleOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.BOOLEAN) {
            return new CommandAPIBooleanOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.CHARACTER) {
            return new CommandAPICharacterOption(this.required, this.nextOption);
        } else if(this.optionType == CommandAPIOptionType.EXTENDED_STRING) {
            return null;
        } else {
            throw new IllegalArgumentException("OptionType not found");
        }
    }
}
