package net.jandie1505.consolecommandapi.result;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;

public abstract class CommandAPIOptionResult {

    public abstract Integer getAsInteger();

    public abstract Long getAsLong();

    public abstract Float getAsFloat();

    public abstract Double getAsDouble();

    public abstract Boolean getAsBoolean();

    public abstract Character getAsChar();

    public abstract String getAsString();

    public abstract CommandAPIOptionType getType();
}
