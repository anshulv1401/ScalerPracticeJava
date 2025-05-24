package dev.anshul.splitwise.command;

import java.util.List;

public class RegisterUserCommand implements Command {

    // Register "UserName" "PhoneNumber" "Password"
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(0).equals(CommandKeywords.RegisterCommand);
    }

    @Override
    public void execute(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
