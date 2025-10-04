package _02_Structural;

/*

    NOTES:
    - Facade Pattern:
        - Is a structural pattern that provides a unified interface to a set of interfaces in a subsystem
        - It simplifies complex systems by offering a high level interface that shields clients from the complexities and interactions of individual components within the subsystem
        - It's especially useful when working with complex systems or third party libraries where a simplified interface can improve usability and hide implementation details


    - 3 Main actors in Facade;
        a. Facade:
            - Provides a simplified interface to a subsystem

        b. Facade Implementation:
            - Implements the facade and manages the interaction with subsystem classes and hides their complexity

        c. Subsystem classes:
            - Are separate classes that make up a complex system. Clients can work with these classes directly but it's more convenient to use the facade


    - Advantages and Disadvantages
        - Advantages:
            - Simplifies usage: It greatly simplifies usage by offering a single entry point to a complex subsystem making it easier or clients to interact with the system. This is beneficial as it reduces the effort required from the user's end
            - Separation: It encourages separation between clients and subsystem classes resulting in loose coupling and simplifying the maintenance process
            - Organization of the code: It provides a well organized and clean method to encapsulate subsystem functionalities offering clients a cleaner and more user friendly API


        - Disadvantages:
            - Reduced flexibility: It reduces flexibility as facade might make it challenging to modify or expand individual subsystem components without impacting the facade itself. This is a significant consideration as it can lead to complications in the long run
            - Bloated interface: As a subsystem evolves and grows the facade system might become overloaded with methods to meed different clients diverse needs. This can make the system cumbersome and less efficient

 */

public class _10_Facade {

}
