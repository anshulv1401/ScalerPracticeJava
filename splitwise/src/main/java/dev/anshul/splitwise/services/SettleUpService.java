package dev.anshul.splitwise.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.anshul.splitwise.CustomObjects.TransactionDto;

@Service
public class SettleUpService {
    public SettleUpService() {
        super();
    }

    public List<TransactionDto> settleUpUser(Long userId) {
        return null;

    }

    public List<TransactionDto> settleUpGroup(Long groupId) {
        return null;
    }

}
