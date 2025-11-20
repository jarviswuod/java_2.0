package _02_Structural;

/*

    NOTES:
    - Facade Pattern:
        - Is a structural design pattern that provides a simplified interface to a complex system to help encapsulate it's complexities and improve the usability


    - 3 Main actors in Facade:
        a. Facade interface:
            - Provides a simplified interface to a subsystem

        b. Concrete Facade:
            - Implements the facade and manages the interaction with subsystem classes and hides their complexity

        c. Subsystem classes:
            - Are separate classes that make up a complex system. Clients can work with these classes directly but it's more convenient to use the facade


    - Advantages and Disadvantages
        - Advantages:
            - Simplifies usage: It greatly simplifies usage by offering a single entry point to a complex subsystem making it easier for clients to interact with the system. This is beneficial as it reduces the effort required from the user's end
            - Separation: It encourages separation between clients and subsystem classes resulting in loose coupling and simplifying the maintenance process
            - Organization of the code: It provides a well organized and clean method to encapsulate subsystem functionalities offering clients a cleaner and more user friendly API


        - Disadvantages:
            - Reduced flexibility: It reduces flexibility as facade might make it challenging to modify or expand individual subsystem components without impacting the facade itself. This is a significant consideration as it can lead to complications in the long run
            - Bloated interface: As a subsystem evolves and grows the facade system might become overloaded with methods to meet different clients diverse needs. This can make the system cumbersome and less efficient

 */

public class _10_Facade {

}
