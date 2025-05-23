package dev.anshul.splitwise.controllers;

import org.springframework.stereotype.Controller;

import dev.anshul.splitwise.dtos.SettleUpGroupRequestDto;
import dev.anshul.splitwise.dtos.SettleUpGroupResponseDto;
import dev.anshul.splitwise.dtos.SettleUpUserRequestDto;
import dev.anshul.splitwise.dtos.SettleUpUserResponseDto;
import dev.anshul.splitwise.services.SettleUpService;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        super();
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserResponseDto) {
        var transactionDto = settleUpService.settleUpUser(settleUpUserResponseDto.getUserId());
        var response = new SettleUpUserResponseDto();
        response.setTransactions(transactionDto);
        return response;
    }

    public SettleUpGroupResponseDto SettleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto) {
        var transactionDto = settleUpService.settleUpGroup(settleUpGroupRequestDto.getGroupId());
        var response = new SettleUpGroupResponseDto();
        response.setTransactions(transactionDto);
        return response;
    }
}
