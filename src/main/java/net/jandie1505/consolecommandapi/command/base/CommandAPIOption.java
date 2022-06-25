package net.jandie1505.consolecommandapi.command.base;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.run.CommandRun;

public abstract class CommandAPIOption {
    private final boolean required;

    protected CommandAPIOption(boolean required) {
        this.required = required;
    }

    public abstract CommandRun handleOption(CommandRun commandRun);

    public abstract CommandAPIOptionType getType();

    public boolean isRequired() {
        return this.required;
    }
}
