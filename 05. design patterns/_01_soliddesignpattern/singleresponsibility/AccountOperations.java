package _01_soliddesignpattern.singleresponsibility;

/*

    NOTES:
    - The deposit() method should not be part or AccountOperations,
    Reason is AccountOperation are responsible for doing  

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
        // Move this method to a different class
    }
}
