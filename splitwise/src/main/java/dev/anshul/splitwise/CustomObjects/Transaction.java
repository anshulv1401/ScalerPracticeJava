package dev.anshul.splitwise.customObjects;

import dev.anshul.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

    private User from;
    private User to;
    private int amount;

}
