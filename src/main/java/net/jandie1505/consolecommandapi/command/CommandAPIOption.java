package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;

public abstract class CommandAPIOption {
    private final boolean required;
    private final CommandAPIOption nextOption;

    public CommandAPIOption(boolean required, CommandAPIOption nextOption) {
        this.required = required;
        this.nextOption = nextOption;
    }

    public abstract CommandAPICommandRun handleOption(String[] cmd, int section, CommandAPICommandRun commandRun);

    public abstract CommandAPIOptionType getType();

    public boolean isRequired() {
        return this.required;
    }

    public CommandAPIOption getNextOption() {
        return nextOption;
    }
}
