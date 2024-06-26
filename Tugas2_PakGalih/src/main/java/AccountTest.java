public class AccountTest {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(500.00, "Natasya Salsabila");
        SavingBonds bonds = new SavingBonds(20, 100, account.getBalance());

        System.out.println("Account Holder: " + account.getName());
        System.out.println("Initial Balance: $" + account.getBalance());
        System.out.println();

        account.withdraw(400); // should be okay
        account.withdraw(-200); // should show warning
        account.withdraw(7000); // should show warning
        account.addBalance(1000);

        bonds.showInterest();
        bonds.showInterest(1000, 2, account.getBalance());
    }
}
