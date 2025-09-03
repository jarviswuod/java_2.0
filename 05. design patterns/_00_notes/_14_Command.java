/*

    NOTES:
    - The command is a behavioral pattern that turns a request into a stand alone object containing all the information about the request
    - This decoupling allows for parameterizing clients with different requests and supports undoable operations.

    - 4 Main actors in Command;
        - Command:
            - Defines all the common interface for all concrete command objects. It usually includes an execute method
        - Concrete Command:
            - Are sublcasses of command that encapsulate a specific action by binding a specific a receiver to the actions execution
        - Invoker class:
            - It holds and manages the command objects. It triggers the execution of commands through the execute method
        - Receiver:
            - Is a class that performs the actual action associated with the command, It knows how to carry out the operation


    - Advantages and Disadvantages
        - Advantages:
            - Decoupling: It promotes decoupling between the sender and the receiver leading to flexible interactions and straightforward maintanance procedures
            - Undo/ Redo support: Are capable of storing state which facilitates the implementation of undo and redo operations, a significant advantage for user experience


        - Disadvantages:
            - Complexity: There is potential for increased complexity within the codebase. Multiple command classes can make the system more challenging to understand and navigate. This is closely related to the issue of class proliferation where the need for various actions could result in an overwhelming number of command classes further complicating the code structure
            - Overkill: At times the design pattern might be consisdered overkill making the code less intuitive and more challening to grasp especially for simpler actions or scenarios

 */

public class _14_Command {

}
