public class CheckingAccount {
    private double balance;
    private String name;

    public CheckingAccount(double initialBalance, String accountHolderName) {
        this.balance = initialBalance;
        this.name = accountHolderName;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
        System.out.printf("Adding $%.2f to your initial balance account || Your balance now: $%.2f\n", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.printf("Withdrawal of $%.2f failed. (Amount cannot be negative) || Your balance now: $%.2f\n", amount, balance);
        } else if (amount > balance) {
            System.out.printf("Withdrawal of $%.2f failed. (Balance is not sufficient) || Your balance now: $%.2f\n", amount, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrawal of $%.2f success || Your balance now: $%.2f\n", amount, balance);
        }
    }
}
