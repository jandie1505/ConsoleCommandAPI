package net.jandie1505.consolecommandapi.result.options;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;

public class CommandAPIDoubleOptionResult extends CommandAPIOptionResult {

    private final double value;

    public CommandAPIDoubleOptionResult(double value) {
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
        return this.value;
    }

    @Override
    public Boolean getAsBoolean() {
        return null;
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
        return CommandAPIOptionType.DOUBLE;
    }
}
