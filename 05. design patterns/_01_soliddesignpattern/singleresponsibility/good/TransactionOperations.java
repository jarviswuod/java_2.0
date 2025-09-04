package _01_soliddesignpattern.singleresponsibility.good;

import java.math.BigDecimal;

public class TransactionOperations {
    // This is good as it does transactions and at right place.
    public void deposit(BigDecimal amount, int accountNumber) {
        // Getting account details is a job for account operations
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.getAccount(accountNumber);
        account.setTotalAmount(account.getTotalAmount().add(amount));
    }

    public void withdraw(BigDecimal amount, int accountNumber) {
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.getAccount(accountNumber);
        account.setTotalAmount(account.getTotalAmount().subtract(amount));
    }
}