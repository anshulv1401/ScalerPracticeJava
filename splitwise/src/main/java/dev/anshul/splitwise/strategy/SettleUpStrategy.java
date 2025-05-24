package dev.anshul.splitwise.strategy;

import java.util.List;

import dev.anshul.splitwise.CustomObjects.Transaction;
import dev.anshul.splitwise.models.Expense;
import dev.anshul.splitwise.models.ExpenseUser;
import dev.anshul.splitwise.models.User;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);

    List<Transaction> settleUp(List<ExpenseUser> expenses, User user);
}
