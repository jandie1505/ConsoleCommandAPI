package net.jandie1505.consolecommandapi.builder;

import net.jandie1505.consolecommandapi.command.CommandAPICommand;
import net.jandie1505.consolecommandapi.command.CommandAPIOption;
import net.jandie1505.consolecommandapi.executors.CommandAPICommandExecutor;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;

import java.util.HashMap;
import java.util.Map;

public class CommandAPICommandBuilder {

    private final Map<String, CommandAPICommand> subcommandMap;
    private CommandAPICommandExecutor commandExecutor;
    private CommandAPICommandExecutor unsuccessfulExecutor;
    private CommandAPICommandExecutor noPermissionExecutor;
    private CommandAPIPermissionRequest permissionRequest;
    private CommandAPIOption option;

    public CommandAPICommandBuilder() {
        this.subcommandMap = new HashMap<>();
        this.commandExecutor = null;
        this.unsuccessfulExecutor = null;
        this.noPermissionExecutor = null;
        this.permissionRequest = null;
        this.option = null;
    }

    public CommandAPICommandBuilder executes(CommandAPICommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        return this;
    }

    public CommandAPICommandBuilder executesUnsuccessful(CommandAPICommandExecutor commandExecutor) {
        this.unsuccessfulExecutor = commandExecutor;
        return this;
    }

    public CommandAPICommandBuilder executesNoPermission(CommandAPICommandExecutor commandExecutor) {
        this.noPermissionExecutor = commandExecutor;
        return this;
    }

    public CommandAPICommandBuilder fromIntegratedCommandExecutor(CommandAPIIntegratedCommandExecutor executor) {
        this.commandExecutor = executor.getExecutor();
        this.unsuccessfulExecutor = executor.getUnsuccessfulExecutor();
        this.noPermissionExecutor = executor.getNoPermissionExecutor();
        return this;
    }

    public CommandAPICommandBuilder setPermissionRequest(CommandAPIPermissionRequest permissionRequest) {
        this.permissionRequest = permissionRequest;
        return this;
    }

    public CommandAPICommandBuilder withSubcommand(String name, CommandAPICommand command) {
        this.subcommandMap.put(name, command);
        return this;
    }

    public CommandAPICommandBuilder setOption(CommandAPIOption option) {
        this.option = option;
        return this;
    }

    public CommandAPICommand build() {
        return new CommandAPICommand(this.commandExecutor, this.unsuccessfulExecutor, this.noPermissionExecutor, this.permissionRequest, this.subcommandMap, this.option);
    }
}
