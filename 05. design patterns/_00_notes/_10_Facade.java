/*

    NOTES:
    - Facade is a structural pattern that provides a unified interface to a set of interfaces in a subsystem. It simplifies complex systems by offering a high level interface that shields clients from the complexities and interactions of individual components within the subsystem.
    - It's expecially useful when working with complex systems or third party libraries where a simplified interface can imporive usability and hide implementation details

    - 3 Main actors in Facade;
        - Facade:
            - Provides a simplified interface to a subsystem
        - Facade Impl:
            - Implements the facade and manages the interaction with subsystem classes and hides their complexity
        - Subsystem classes:
            - Are separate classes that make up a complex system. Clients can work with these classes directly but it's more convenient to use the facade


    - Advantages and Disadvantages
        - Advantages:
            - Simplifies usage: It greatly simplifies usage by offering a single entry point to a complex subsystem making it easier or clients to interact with the system. This is beneficial as it reduces the effort required from the user's end
            - Separation: It encourages separation between clients and subsystem classes resulting in loose coupling and simplifing the maintenance process
            - Organisation of the code: It provides a well organised and clean method to encapsulate subsystem fucntionalities offering clients a cleaner and more userfriendly API


        - Disadvantages:
            - Reduced flexibility: It reduces flexilibity as facade migth make it challenging to modify or expand indivirual subsystem components without impacting the facade itself. This is a significant consideration as it can lead to complications in the long run
            - Bloated interface: As a subsystem evovles and grows the facade system might become overloaded with methods to meed different clients diverse needs. This can make the system cumbersome and less efficient

 */

public class _10_Facade {

}
