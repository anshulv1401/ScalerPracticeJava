package dev.anshul.splitwise.command;

import java.util.List;

import dev.anshul.splitwise.controllers.SettleUpController;
import dev.anshul.splitwise.dtos.SettleUpUserRequestDto;

public class SettleUpUserCommand implements Command {

    private SettleUpController controller;

    public SettleUpUserCommand(SettleUpController controller) {
        super();
        this.controller = controller;
    }

    // "UserId" SettleUp
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 2 && words.get(1).equals(CommandKeywords.SettleUpUserCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(""));

        Long userId = Long.valueOf(words.get(0));

        var request = new SettleUpUserRequestDto();
        request.setUserId(userId);

        var response = controller.settleUpUser(request);
        response.getTransactions();
    }

}
