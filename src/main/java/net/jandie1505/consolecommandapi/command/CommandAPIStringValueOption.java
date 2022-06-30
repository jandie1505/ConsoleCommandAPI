package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.options.CommandAPIStringOptionResult;

public class CommandAPIStringValueOption extends CommandAPIOption {

    public CommandAPIStringValueOption(boolean required, CommandAPIOption nextOption) {
        super(required, nextOption);
    }

    @Override
    public CommandAPICommandRun handleOption(String[] cmd, int section, CommandAPICommandRun commandRun) {

        commandRun.addOption(new CommandAPIStringOptionResult(cmd[section]));

        commandRun = this.getNextOption().handleOption(cmd, section + 1, commandRun);

        return commandRun;
    }

    @Override
    public CommandAPIOptionType getType() {
        return CommandAPIOptionType.STRING;
    }
}
