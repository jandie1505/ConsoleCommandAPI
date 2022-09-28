import net.jandie1505.consolecommandapi.builder.CommandAPICommandBuilder;
import net.jandie1505.consolecommandapi.builder.CommandAPICommandHandlerBuilder;
import net.jandie1505.consolecommandapi.builder.CommandAPIOptionBuilder;
import net.jandie1505.consolecommandapi.command.CommandAPICommandHandler;
import net.jandie1505.consolecommandapi.enums.CommandAPIOptionType;
import net.jandie1505.consolecommandapi.executors.CommandAPIPermissionRequest;
import net.jandie1505.consolecommandapi.sender.CommandAPICommandSender;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {
        CommandAPICommandHandler commandHandler = new CommandAPICommandHandlerBuilder()
                .executesCommandNotFound(result -> {
                    System.out.println("Command not found");
                })
                .executesNoPermission(result -> {
                    System.out.println("No permission");
                })
                .setPermissionRequest(CommandAPIPermissionRequest.alwaysSuccess())
                .build();

        commandHandler.addCommand(
                "test",
                new CommandAPICommandBuilder()
                        .executes(result -> {
                            System.out.println("ich bin ein command mit den options " + result.getOptions());
                        })
                        .executesUnsuccessful(result -> {
                            System.out.println("Ich war nicht erfolgreich");
                        })
                        .executesNoPermission(result -> {
                            System.out.println("Ich habe keine Rechte");
                        })
                        .setPermissionRequest(CommandAPIPermissionRequest.alwaysSuccess())
                        .withSubcommand("test2",
                                new CommandAPICommandBuilder()
                                        .executes(result -> System.out.println("hi"))
                                        .setPermissionRequest(CommandAPIPermissionRequest.alwaysSuccess())
                                        .build()
                        )
                        /*.setOption(
                                new CommandAPIOptionBuilder(CommandAPIOptionType.STRING)
                                        .setRequired(true)
                                        .setNextOption(
                                                new CommandAPIOptionBuilder(CommandAPIOptionType.STRING)
                                                        .setRequired(false)
                                                        .build()
                                        )
                                        .build()
                        )*/
                        .build()
        );

        TimeUnit.SECONDS.sleep(1);

        System.out.println("------");

        commandHandler.onCommand(new CommandAPICommandSender() {}, new String[]{"test","test2"});
    }
}
