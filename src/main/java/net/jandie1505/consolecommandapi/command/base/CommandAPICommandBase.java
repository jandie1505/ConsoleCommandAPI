package net.jandie1505.consolecommandapi.command.base;

import net.jandie1505.consolecommandapi.command.options.CommandAPISubcommandOption;
import net.jandie1505.consolecommandapi.command.options.CommandAPIValueOption;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;
import net.jandie1505.consolecommandapi.run.CommandRun;

public abstract class CommandAPICommandBase extends CommandAPICommandPart {
    protected final CommandAPICommandExecutor commandExecutor;
    protected final CommandAPICommandExecutor noPermissionExecutor;
    protected final CommandAPIPermissionRequest permissionRequest;
    protected final CommandAPIOption nextOption;

    public CommandAPICommandBase(CommandAPICommandExecutor commandExecutor, CommandAPICommandExecutor noPermissionExecutor, CommandAPIPermissionRequest permissionRequest, CommandAPIOption commandOption) {
        this.nextOption = commandOption;
        this.commandExecutor = commandExecutor;
        this.noPermissionExecutor = noPermissionExecutor;
        this.permissionRequest = permissionRequest;
    }

    public void onCommand(String[] cmd, int section, CommandRun commandRun) {
        if(this.permissionRequest.hasPermission()) {

            if(this.nextOption instanceof CommandAPISubcommandOption) {
                this.nextOption.handleOption(commandRun);
            } else if (this.nextOption instanceof CommandAPIValueOption) {
                commandRun = this.nextOption.handleOption(commandRun);
            } else {
                this.commandExecutor.onCommand(commandRun.buildResult());
            }

        } else {
            this.noPermissionExecutor.onCommand();
        }
    }
}
