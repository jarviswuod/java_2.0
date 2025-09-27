package _01_soliddesignpattern.singleresponsibility.bad;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountOperations {
    private static Map<Integer, Account> accountMap = new HashMap<>();

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void updateAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public Account getAccount(int accountNumber) {
        return accountMap.get(accountNumber);
    }

    // Move this method to different class
    public void deposit(BigDecimal amount, int accountNumber) {
        Account account = getAccount(accountNumber);
        account.setTotalAmount(account.getTotalAmount().add(amount));
    }

    // Move this method to different class
    public void withdraw(BigDecimal amount, int accountNumber) {
        Account account = getAccount(accountNumber);
        account.setTotalAmount(account.getTotalAmount().subtract(amount));
    }
}