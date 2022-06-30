package net.jandie1505.consolecommandapi.result.options;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;

public class CommandAPIBooleanOptionResult extends CommandAPIOptionResult {

    private final boolean value;

    public CommandAPIBooleanOptionResult(boolean value) {
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
        return this.value;
    }

    @Override
    public Character getAsChar() {
        return null;
    }

    @Override
    public String getAsString() {
        return String.valueOf(this.value);
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.BOOLEAN;
    }
}
