package _01_soliddesignpattern.singleresponsibility.good;

/*

    NOTES:
    - Single responsibility principle states that whatever class you create should have only have a single responsibility/ have only one reason to change 
    - Whatever classes you have should have only one responsibility and that responsibility should only be followed by that class
    - To know if the principle is followed just ask one question, what the responsibility it does and when you discover "and" that means it's not a solid design principle



 */

/*

    NOTES:
    - The deposit method should not be part of AccountOperations
        public void deposit(int amount, int accountNumber) {}

        - Reason is account operations are responsible for doing operation for account like add account, update account get account. However deposit is something called as transaction which eventually not responsible by account. Adding this method violates Single Responsibility principle
        
        N/B:
        - Create new class which actually does TransactionOperations.

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

        TransactionOperations transactionOperations = new TransactionOperations();
        transactionOperations.deposit(BigDecimal.valueOf(123), 1230);

    }
}
