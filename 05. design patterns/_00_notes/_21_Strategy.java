/*

    NOTES:
    - Strategy is a behavioral design pattern that defines a family of interchangeable algorithm and allows them to be selected and used dynamically at runtime.
    - THis also enables algorithms to be encapsulated in separate classes

    - 3 Main actors in Strategy;
        - Context:
            - A class that maintains a refrence to the strategy object and delegates the algorithms execution to it
        - Strategy:
            - A common interface for all specific strategies it decleares a method for an algorithm
        - Concrete Strategy:
            - Is a class that implements the strategy interface providig a concrete algorithm


    - Advantages and Disadvantages
        - Advantages:
            - Flexibility: It enhances adaptability ans flexibility allowing the algorithms to be changes at runtime without modifing the client code
            - Separation of concerns: It encapsulates the algoritms in separate strategy classes from promoting a clear separation of tasks and simplifying maintenance
            - Openclosed principle: THe strategy ensures that the system is open for extensions but closed for modifications adhering to the open-closed principle


        - Disadvantages:
            - Complexity: It introduces additional complexity particularly when there are numerous strategies and their interactions to manage
            - Responsibility of the client: Clients are burdened with the responsibility of selecting and proving an appropritate strategy for the context, potentially leading to an increase in the client code

 */

public class _21_Strategy {

}
