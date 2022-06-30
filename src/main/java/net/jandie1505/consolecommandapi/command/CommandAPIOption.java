package net.jandie1505.consolecommandapi.command;

import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPIStringOptionResult;

public abstract class CommandAPIOption {
    private final boolean required;
    private final CommandAPIOption nextOption;

    public CommandAPIOption(boolean required, CommandAPIOption nextOption) {
        this.required = required;
        this.nextOption = nextOption;
    }

    public abstract CommandAPIOptionResult getResult(String string);

    public abstract CommandAPIOptionType getType();

    public CommandAPICommandRun handleOption(String[] cmd, int section, CommandAPICommandRun commandRun) {
        if(cmd.length >= section) {

            CommandAPIOptionResult optionResult = getResult(cmd[section]);

            if(optionResult != null) {
                commandRun.addOption(optionResult);
            } else {
                return commandRun;
            }

            if(this.getNextOption() != null) {
                commandRun = this.getNextOption().handleOption(cmd, section + 1, commandRun);
            }

        }

        return commandRun;
    }

    public boolean isRequired() {
        return this.required;
    }

    public CommandAPIOption getNextOption() {
        return nextOption;
    }
}
