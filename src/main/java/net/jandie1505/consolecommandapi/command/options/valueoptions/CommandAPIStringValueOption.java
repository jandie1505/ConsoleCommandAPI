package net.jandie1505.consolecommandapi.command.options.valueoptions;

import net.jandie1505.consolecommandapi.command.options.CommandAPIValueOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;

public class CommandAPIStringValueOption extends CommandAPIValueOption {
    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.STRING;
    }

    @Override
    public int getAsInteger() {
        return 0;
    }

    @Override
    public long getAsLong() {
        return 0;
    }

    @Override
    public float getAsFloat() {
        return 0;
    }

    @Override
    public double getAsDouble() {
        return 0;
    }

    @Override
    public boolean getAsBoolean() {
        return false;
    }

    @Override
    public char getAsChar() {
        return 0;
    }

    @Override
    public String getAsString() {
        return null;
    }

    @Override
    public String getAsExtendedString() {
        return null;
    }
}
