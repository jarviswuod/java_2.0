package _02_OopPrinciples.Encapsulation.good;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        deposit(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit Amount  must be positive");
        }
        this.balance += amount;
    }

    public void widthdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Widthdraw Amount  must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient Funds");
        }
        this.balance -= amount;
    }
}
