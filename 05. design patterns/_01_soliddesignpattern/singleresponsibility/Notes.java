package _01_soliddesignpattern.singleresponsibility;

/*

    NOTES:
    - Single responsibility principle states that whatever class you create should have only have a single responsibility/ have only one reason to change 
    - To know if the principle is followed just ask one question, what the responsibility it does and when you discover "and" that means it's not a solid design principle

    - Example Explained:
        - AccountOperations violates the single responsibility as it has both 'account operations' and 'deposit' a 'transactions Operation'  too
        - 'deposit' function should be moved to transcation to make it right

 */

public class Notes {
}
