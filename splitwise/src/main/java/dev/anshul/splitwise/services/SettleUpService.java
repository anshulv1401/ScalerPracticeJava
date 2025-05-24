package dev.anshul.splitwise.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.anshul.splitwise.customObjects.Transaction;
import dev.anshul.splitwise.models.Expense;
import dev.anshul.splitwise.repositories.ExpenseRepository;
import dev.anshul.splitwise.repositories.ExpenseUserRepository;
import dev.anshul.splitwise.repositories.GroupRepository;
import dev.anshul.splitwise.repositories.UserRepository;
import dev.anshul.splitwise.strategy.SettleUpStrategy;

@Service
public class SettleUpService {

    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStrategy settleUpStrategy;
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;

    public SettleUpService(UserRepository userRepository, GroupRepository groupRepository,
            ExpenseRepository expenseRepository, ExpenseUserRepository expenseUserRepository,
            SettleUpStrategy settleUpStrategy) {
        super();
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.expenseUserRepository = expenseUserRepository;
    }

    public List<Transaction> settleUpUser(Long userId) {

        var optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty())
            throw new RuntimeException("User is invalid in the request");

        var user = optionalUser.get();

        var expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();
        for (var expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }
        return settleUpStrategy.settleUp(expenses.stream().toList());
    }

    public List<Transaction> settleUpGroup(Long groupId) {

        var optionalGroup = groupRepository.findById(groupId);

        if (optionalGroup.isEmpty())
            throw new RuntimeException("Group is invalid in the request");

        var group = optionalGroup.get();

        var expenses = expenseRepository.findAllByGroup(group);

        // Black box(list of expenses) => list of txn
        return settleUpStrategy.settleUp(expenses);
    }

}
