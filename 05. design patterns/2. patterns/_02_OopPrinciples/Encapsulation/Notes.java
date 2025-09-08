package _02_OopPrinciples.Encapsulation;

/*

    NOTES:
    - Encapsulation involves bundling the data or attributes or fields and the methods/behaviours that operate into that data into a single unit
    - It helps in hiding the internal implementations of a class by only exposing the necessary  fucntionalities of a class to the outside world

    - Explanation:
        - In this example the BankAccount class encapulates the account data, in this case the account balance, and all the related methods, deposit() and widthdraw() in a single unit. The data members, the balance are marked as private, encapsulating them within the class and preventing direct access from outside of the class.
        - Getter methods are used to provide controlled access to the private data member(balance)
        - Methods deposit() and widthdraw() are used to manipulate balance ensuring operations are performed safely and according to the  business rules, we have checks to ensure nothing is incorrect so thr program logic can't be violated from outside the class. Example;
            - It's not posible to widthdraw more money than what is inside the account
        - Encapsulation of logic inside the methods in BankAccount also means users dont have to worry about the implemetation details when interacting with the BackAccount object. Example;
            - The user doesn't have to worry about the logic involved in widthdrawing the money, they just call the withdraw method and the implementatuion detials of widthdrawing money are hideden from the clients and encapulated. And if the user tries to do something stupid like deposit a negative amount of money then the program will throw an error and the user will be modified.
        - The main method, we are demonstrating how to create an instance of BankAccount and interact with its properties and methods without needig to know the internal implementation details

        - Encapsulation abstracts away the complexity of the implemetations detials allowing users to focus on higer level fucntionality provided by the BankAccount class, so the users only need to know the public interface of the BankAccount class, i.e, the public methods or properties to use it effectively while the internal implementation detials remain hidden

        - Encapsulation allows for a clear separation between the public interface and the internal implemetation of a class proviing users with a simplified and intuitive way to interact with objects while hiding the complexity of how those interactiosn are handled internally

 */

public class Notes {

}
