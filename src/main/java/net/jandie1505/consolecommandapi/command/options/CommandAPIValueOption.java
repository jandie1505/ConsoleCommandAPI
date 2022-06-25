package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.base.CommandAPIOption;

public abstract class CommandAPIValueOption extends CommandAPIOption {

    public abstract int getAsInteger();

    public abstract long getAsLong();

    public abstract float getAsFloat();

    public abstract double getAsDouble();

    public abstract boolean getAsBoolean();

    public abstract char getAsChar();

    public abstract String getAsString();

    public abstract String getAsExtendedString();
}
