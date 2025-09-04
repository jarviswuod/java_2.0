package _01_soliddesignpattern.singleresponsibility.bad;

/*

    NOTES:
    - The deposit method should not be part of AccountOperations
        public void deposit(int amount, int accountNumber) {}

        - Reason is account operations are responsible for doing operation for account like add account, update account get account. However deposit is something called as transaction which eventually not responsible by account. Adding this method violates Single Responsibility principle
        
        N/B:
        - Create new class which actually does TransactionOperations.

 */

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

    public void deposit(int amount, int accountNumber) {
        // Move this method to different class
    }
}