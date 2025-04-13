import Bank.BankAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        BankAccount bankAccount = new BankAccount("Anshul Vanawat", 5000);

        try {
            bankAccount.deposit(100);
            bankAccount.withdraw(50);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        bankAccount.printTransactionHistory();
    }
}