package dev.anshul.splitwise.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import dev.anshul.splitwise.CustomObjects.Transaction;
import dev.anshul.splitwise.models.Expense;
import dev.anshul.splitwise.models.ExpenseUser;
import dev.anshul.splitwise.models.ExpenseUserType;
import dev.anshul.splitwise.models.User;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {

        /*
         * Write algo
         * 1. Find balances of each user (+ for lender, - for borrower)
         * 2. Take 2 heaps - one min heap and one max heap
         * 3. Keep popping one(min balance from the min heap) one element from both till
         * both becomes empty(max balance from max heap)
         * 4. Keep adding the coresponding txns to the list of txn
         * 5. return the list
         */

        Map<User, Long> userToBalanceMap = new HashMap<>();

        for (Expense expense : expenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                var user = expenseUser.getUser();
                var amount = expenseUser.getAmount();
                if (expenseUser.getExpenseUserType().equals(ExpenseUserType.LENDER)) {
                    userToBalanceMap.put(user, userToBalanceMap.getOrDefault(user, 0L) + amount);
                } else {
                    userToBalanceMap.put(user, userToBalanceMap.getOrDefault(user, 0L) - amount);
                }
            }
        }

        // TODO
        // map will contain balance of every user

        return null;
    }

    @Override
    public List<Transaction> settleUp(List<ExpenseUser> expenses, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'settleUp'");
    }
}
