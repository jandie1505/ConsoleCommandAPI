package net.jandie1505.consolecommandapi.result.options;

import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;

public class CommandAPIStringOptionResult extends CommandAPIOptionResult {

    private final String value;

    public CommandAPIStringOptionResult(String value) {
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
        return null;
    }

    @Override
    public String getAsString() {
        return this.value;
    }

    @Override
    public String getAsExtendedString() {
        return null;
    }
}
