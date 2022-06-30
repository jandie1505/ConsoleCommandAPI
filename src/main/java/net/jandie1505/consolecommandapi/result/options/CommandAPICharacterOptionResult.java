package net.jandie1505.consolecommandapi.result.options;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;

public class CommandAPICharacterOptionResult extends CommandAPIOptionResult {

    private final char value;

    public CommandAPICharacterOptionResult(char value) {
        this.value = value;
    }

    @Override
    public Integer getAsInteger() {
        return null;
    }

    @Override
    public Long getAsLong() {
        return null;
    }

    @Override
    public Float getAsFloat() {
        return null;
    }

    @Override
    public Double getAsDouble() {
        return null;
    }

    @Override
    public Boolean getAsBoolean() {
        return null;
    }

    @Override
    public Character getAsChar() {
        return this.value;
    }

    @Override
    public String getAsString() {
        return String.valueOf(this.value);
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.CHARACTER;
    }
}
