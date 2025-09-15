package _02_OopPrinciples.Encapsulation;

/*

    NOTES:
    - Encapsulation;
        - Referes to hiding the internal implementations details of a class and only exposing the necessary functionalities
        - Encapsulation allows for a clear separation between the public interface and the internal implemetation of a class providing users with a simplified and intuitive way to interact with objects while hiding the complexity of how interactions are handled internally


    - BAD CODE EXPLANATION:
        - This is a bad example with no encapsulation
                public class BankAccount {

                    public double balance;
                }

        - Over here we only have one fiels called **balance** which is public, the issue with this is since it;s public all clients that use the class *BankAccount* can directly change the balance field into whatever value they want incluvise of a negative balance which is not logically correct

                public class Main {
                    public static void main(String[] args) {

                        BankAccount account = new BankAccount();
                        account.balance = 100;
                        account.balance = -50;
                    }
                }


    - GOOD CODE EXPLANATION:
        - Over here *BankAccount* class encapsulates the **account** field which is now private preventing direct access from outside of the class
                public class BankAccount {
                    private double balance;
                }

        - The getBalance() method is used to provide controlled access to the private field **balance**
                public double getBalance() {
                    return balance;
                }

        - The methods deposit() and widthdraw() are used to manipulate **balance** field ensuring operations are performed safely and according to the business rules i.e, we have checks to ensure nothing is incorrect and program logic can't be violated from outside the class. Example;
            - Widthdrawing more money than what is inside the BankAccount class
                public void deposit(double amount) {
                    if (amount <= 0) {
                        throw new IllegalArgumentException("Deposit Amount  must be positive");
                    }
                    this.balance += amount;
                }


        - EXTRA INFO:
            - Encapsulation of BankAccount class also means users don't have to worry about the implemetation details when interacting with a BackAccount instance. Example;
                - A user doesn't have to worry about logic involved in widthdrawing money, they just call the withdraw method
                - If the user tries to deposit a negative amount of money, the program will throw an error to notify them

 */

public class Notes {
}