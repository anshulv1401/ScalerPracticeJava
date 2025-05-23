package dev.anshul.splitwise.CustomObjects;

import dev.anshul.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

    private User from;
    private User to;
    private int amount;

}
