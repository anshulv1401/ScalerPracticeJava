package dev.anshul.splitwise.command;

import java.util.List;

public class CommandExecutor {

    public List<Command> commands;

    public CommandExecutor(SettleUpUserCommand settleUpUserCommand, RegisterUserCommand registerUserCommand,
            CreateGroupCommand createGroupCommand) {
        super();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
