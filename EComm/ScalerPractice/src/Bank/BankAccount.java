package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private List<String> transactions;
    private double balance;
    private String ownerName;

    public BankAccount () {
        balance = 0;
        ownerName = "";
        transactions = new ArrayList<>();
    }

    public BankAccount (String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public void deposit(double amt) throws Exception {
        if (0 >= amt)
            throw new Exception("Invalid amount");

        balance += amt;
        transactions.add("Deposited $" + amt);
    }

    public void withdraw(double amt) throws Exception {
        if (0 >= amt)
            throw new Exception("Invalid amount");

        if (balance < amt)
            throw new Exception("Insufficient fund");
        balance -= amt;

        transactions.add("Withdrew $" + amt);
    }

    public void printTransactionHistory()
    {
        for (String transaction : transactions)
            System.out.printf(transaction);
    }

    BankAccount()
    {

    }
}
