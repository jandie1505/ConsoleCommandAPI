package net.jandie1505.consolecommandapi.command.options;

import net.jandie1505.consolecommandapi.command.CommandAPICommandRun;
import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.result.CommandAPIOptionResult;
import net.jandie1505.consolecommandapi.result.options.CommandAPIStringOptionResult;

public class CommandAPIExtendedStringOption extends CommandAPIOption {

    public CommandAPIExtendedStringOption(boolean required) {
        super(required, null);
    }

    @Override
    public CommandAPICommandRun handleOption(String[] cmd, int section, CommandAPICommandRun commandRun) {
        if(cmd.length >= section + 1) {

            String extendedString = "";
            for(int i = section; i < cmd.length; i++) {
                extendedString = extendedString + " " + cmd[i];
            }

            commandRun.addOption(new CommandAPIStringOptionResult(extendedString));

        }

        return commandRun;
    }

    @Override
    public CommandAPIOptionResult getResult(String string) {
        return null;
    }

    @Override
    public CommandAPIOptionType getType() {
        return null;
    }
}
