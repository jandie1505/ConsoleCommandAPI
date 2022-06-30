package net.jandie1505.consolecommandapi.result.options;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;

public class CommandAPIIntegerOptionResult extends CommandAPIOptionResult {

    private final int value;

    public CommandAPIIntegerOptionResult(int value) {
        this.value = value;
    }

    @Override
    public Integer getAsInteger() {
        return this.value;
    }

    @Override
    public Long getAsLong() {
        return (long) this.value;
    }

    @Override
    public Float getAsFloat() {
        return (float) this.value;
    }

    @Override
    public Double getAsDouble() {
        return (double) this.value;
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
        return CommandAPIOptionType.INTEGER;
    }
}
