package _01_OopPrinciple.Encapuslation;

public class Bank {

    private double balance;

    public Bank() {
        deposit(1000);
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            throw new IllegalArgumentException("Amount must not be negative");
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance)
                throw new IllegalArgumentException("No enough balance to withdraw Amount " + amount);
            balance -= amount;
        } else
            throw new IllegalArgumentException("Amount must not be negative");
    }

}
