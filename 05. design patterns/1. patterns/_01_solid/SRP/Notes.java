package _01_solid.SRP;

/*

    NOTES:
    - Single responsibility principle states that whatever class you create should have only have a single responsibility/ have only one reason to change 
    - To know if the principle is followed just ask one question, what responsibility your class does and when you discover "and" that means solid principle is NOTE FOLLOWED

    - BAD Example Explained:
        - AccountOperations violates the single responsibility as it has both 'account operations' and 'deposit' a 'transactions Operation'  too. The deposit method should not be part of AccountOperations
        - Reason is account operations are responsible for doing operation for account like add account, update account get account. However deposit is something called as transaction which eventually not responsible by account. Adding this method violates Single Responsibility principle
            public void deposit(int amount, int accountNumber) {...}
            
        N/B:
        - Create new class which actually does TransactionOperations.


    - GOOD Example Explained:
        - TransactionOperations class is created to help handle deposit() and withdrawal() methods, this allows for single responsibility to be followed since AccountOperation does what is should to and TransactionOperations also does what is should do too.

 */

public class Notes {
}
