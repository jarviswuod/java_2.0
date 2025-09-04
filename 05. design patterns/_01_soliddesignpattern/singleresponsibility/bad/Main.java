package _01_soliddesignpattern.singleresponsibility.bad;

/*

    NOTES:
    - Single responsibility principle states that whatever class you create should have only have a single responsibility/ have only one reason to change 
    - Whatever classes you have should have only one responsibility and that responsibility should only be followed by that class
    - To know if the principle is followed just ask one question, what the responsibility it does and when you discover "and" that means it's not a solid design principle

 */

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
        accountOperations.deposit(123, 1230);

    }
}
