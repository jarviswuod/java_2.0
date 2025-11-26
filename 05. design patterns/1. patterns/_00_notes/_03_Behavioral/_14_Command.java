package _03_Behavioral;

/*

    NOTES:
    - Command Pattern:
        - Is a pattern that turns a request into a stand-alone object that contains all information about the request
        - This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations


    - 4 Main actors in Command:
        a. Command:
            - Defines all the common interface for all concrete command objects. It usually includes an execute*() method

        b. Concrete Command:
            - Are sub-classes of command that encapsulate a specific action by binding a specific receiver to the actions execution

        c. Invoker:
            - It holds and manages the Command objects. It triggers the execution of commands through the execute() method

        d. Receiver:
            - Is a class that performs the actual action associated with the command. It knows how to carry out the operation


    - Advantages and Disadvantages
        - Advantages:
            - Decoupling: It promotes decoupling between the sender and the receiver leading to flexible interactions and straightforward maintenance procedures
            - Undo/ Redo support: Are capable of storing state which facilitates the implementation of undo and redo operations, a significant advantage for user experience


        - Disadvantages:
            - Complexity: There is potential for increased complexity within the code base. Multiple command classes can make the system more challenging to understand and navigate. This is closely related to the issue of class proliferation where the need for various actions could result in an overwhelming number of command classes further complicating the code structure
            - Overkill: At times the design pattern might be considered overkill making the code less intuitive and more challenging to grasp especially for simpler actions or scenarios

 */

public class _14_Command {

}
