public class SavingBonds {
    int bond;
    double price, balance, interest, totalPrice;

    SavingBonds(int bond, double price, double balance) {
        this.bond = bond;
        this.price = price;
        this.balance = balance;
    }

    public void showInterest() {
        for (int i = 1; i <= bond; i++) {
            switch (i) {
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11:
                    interest = price / bond + price * 0.5 / 100;
                    break;
                case 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23:
                    interest = price / bond + price * 1 / 100;
                    break;
                case 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35:
                    interest = price / bond + price * 1.5 / 100;
                    break;
                case 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47:
                    interest = price / bond + price * 2 / 100;
                    break;
                case 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60:
                    interest = price / bond + price * 2.5 / 100;
                    break;
            }
            totalPrice += interest;
            if (balance < interest) {
                System.out.printf("(Month %d) Payment failed! Your balance is not enough!\n", i);
                break;
            } else {
                balance -= interest;
                System.out.printf("(Month %d) you pay $%.2f || Your balance now: $%.2f\n", i, interest, balance);
                if (i == bond) {
                    System.out.printf("Payment done! Normal price: $%.2f || %d Month bond total price: $%.2f\n", price, bond, totalPrice);
                }
            }
        }
    }

    public void showInterest(double price, int bond, double balance) {
        this.price = price;
        this.bond = bond;
        this.balance = balance;
        showInterest();
    }
}
