package _01_soliddesignpattern.singleresponsibility.bad;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("Wuod");
        account.setTotalAmount(BigDecimal.valueOf(100000));

        AccountOperations accountOperations = new AccountOperations();
        accountOperations.addAccount(account);

        // BAD - SINGLETON RULE BROKEN
        accountOperations.deposit(BigDecimal.valueOf(123), 123);

    }
}