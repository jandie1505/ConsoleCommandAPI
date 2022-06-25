package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.base.CommandAPIOption;
import net.jandie1505.consolecommandapi.command.commands.CommandAPISubcommand;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;

import java.util.HashMap;
import java.util.Map;

public class CommandAPISubcommandOption extends CommandAPIOption {
    private final Map<String, CommandAPISubcommand> subcommands;

    public CommandAPISubcommandOption(Map<String, CommandAPISubcommand> subcommands) {
        this.subcommands = new HashMap<>(subcommands);
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.SUBCOMMAND;
    }

    public Map<String, CommandAPISubcommand> getSubcommands() {
        return Map.copyOf(this.subcommands);
    }
}
