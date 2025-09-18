package _04_DesignPatterns.Behavioral.Command;

/*

    NOTES:
    - Command Pattern:
        - It's a behavioral design pattern that encapsulates a request as an object, allowing you to parameterize clients with queues, requests, or operations
        - It enables you to decouple the sender from the receiver, providing flexibility in the execution of commmands and supporting undoable operations


    - CHALLENGE:
        - Consider a situation where we are creating a remote control that if connected to lights, and the light can either be switched on or off. How could you handle this situation?


    - SOLUTION 1:

            _______________________             _______________
            | RemoteControl       |             | Light       |
            |_____________________|<>---------->|_____________|
            | light: Light        |             | turnOn()    |
            |_____________________|             | turnOff()   |
            | pressButton(turnOn) |             | dim()       |
            | dimLight()          |             |_____________|
            |_____________________|


        - This solution works great but we have an issue:
            - It violates the open-closed principle for Light is tightly coupled to RemoteControl. This means if we want to add new features such as dimming light or changing color, then we have to modify RemoteControl class



    - SOLUTION 2: Using the Command Pattern;
        - Using the Command Pattern, we decouple RemoteControl, sender class from Light, receiver class. Then to add new functionality such as dimming the light, we just extend our codebase by adding a new DimCommand class without having to modify RemoteControl class
        - The RemoteControl is composed of Command
        - The concrete command classes TurnOn and TurnOff implement Command and store a reference to Light

                _________________             _____________
                | RemoteControl |             | Command   |
                |_______________|<>---------->|___________|
                | command       |             | execute() |
                |_______________|             |___________|
                | pressButton() |                   |
                |_______________|                   |
                                           _________|__________
                                           |                  |
                                           V                  V
                _____________          _____________     _____________
                | Light     |          | TurnOn    |     | TurnOff   |
                |___________|<--|      |___________|     |___________|
                | turnOn()  |   |      | light     |     | light     |
                | turnOff() |   |      |___________|     |___________|
                | dim()     |   |      | execute() |     | execute() |
                |___________|   |      |___________|     |___________|
                                |___________|__________________|


    - UNDO WITH COMMAND PATTERN:
        - The Command Pattern is also commonly used in UI frameworks, especially for handling user interactions with buttons or menu items. Each button or menu item can be associated with a specific command object allowing the framework to execute the appropriate action when the user interacts with the UI element. This decouples the UI components from the actual operations they perform on facilitating features like undo/redo as and event logging in UI application

                ____________________           ______________
                | Button           |           | Command    |
                |__________________|<>-------->|____________|
                | command: Command |           | execute()  |
                |__________________|           |____________|
                | click()          |                 ^
                |__________________|                 |
                                                     |                   FRAMEWORK:
            _________________________________________|___________________________
                                                     |                   APP:
                                              _______________
                    _______________           | AddUser     |
                    | UserService |           |_____________|
                    |_____________|<----------| userService |
                    | addUser()   |           |_____________|
                    |_____________|           | execute()   |
                                              |_____________|


        - The 'FRAMEWORK' would be code that you couldn't edit, i.e some UI package, and the 'APP' is one that you create
        - You would create concrete commands that extend the Command interface found in the UI package. Your concrete commands keeps a reference to a class that contains the business logic, such as UserService, which contains methods related to adding, updating, and deleting users



        - Undo feature without Command pattern:
            - A simpler solution, without the Command pattern would be to createing a load of Button subclasses for each place where a button is used. These subclasses would contain the code for what should happen when that button is clicked

                                        _________________
                                        |  Button       |
                                        |_______________|

                _________________  __________________   _________________   _________________
                | AddUserButton |  | CloseWindowBtn |   |  SaveButton   |   |  PrintButton  |
                |_______________|  |________________|   |_______________|   |_______________|

                _________________  _________________   _________________   _________________
                | BrightButton  |  | OpenWindowBtn |   |  CutButton    |   |  CopyButton   |
                |_______________|  |_______________|   |_______________|   |_______________|


            - Problems: This is a fragile solution
                - One ends up with a huge number of subclasses which would be OK if there was no risk of breaking the code in these subclasses every time the base Button class is modified. But if we have updates our UI library and it includes a breaking change to the button class, then, it could break all our button classes

                - Some operations, such as "Copy" need to be called from multiple places. Example;
                    - A user can click the copy button, press "Ctrl + C" or right-click and select 'copy' logic from the context menu
                    - With this solution, we'd either have to duplicate the copy logic in multiple classes, or make shortcuts and context menus dependent on buttons, which is a very bad solution



        - UNDO feature with COMMAND PATTERN:
            - The Command Pattern solves this issue by breaking the APP into layers following the good software design principle called "principle of separation of concerns"
            - The Command Pattern breaks the APP into two layers;
                1. The GUI is responsible for rendering things on the screen, capturing user input, and showing results
                2. Then when it comes to the Important stuff, such as validating the info from a contact form and sending an email, the GUI delegates that task to the underlying layer of business logic

            
            - Another common use case for the Command Pattern is to implement undo functionality. By storing a history of executed commands, you can easily reverse the effects of previous operations

                    _________________
                    | Command       |
                    |_______________|
                    | execute()     |
                    |_______________|
                            ^
                            |
                            |
                    _________________
                    | UndoCommand   |
                    |_______________|
                    | unexecute()   |
                    |_______________|
                            ^
                            |
                            |
                    _________________
                    | ItalicCommand |
                    |_______________|
                    | execute()     |
                    | unexecute()   |
                    |_______________|


                - Above , we creat a new interface class called UndoCommand, which iextends Command; this is because undoable commmands are still. Why not add the unexecute() method to the Command interface? Because not all commands are undoable. Some commands, such as sending an email or processing a payment, may not have a meaningful undo operation

                - We can then create concrete command classes, such as ItalicCommand, that implement both execute() and unexecute() methods. The execute() method applies the italic formatting, while the unexecute() method removes it

                - We can also use the Memento Patten to implement undo mechanisms. THe difference between Memento and Command patterns when it comes to undo operations is Memento, we store the changes in the state of an object i.e. we keep multiple snapshots over time. Sometimes, storing these snapshots can be memory intensive, especially if the object's state is large or complex(videos are large and consume loads of memory).

                - In those conditions, it's better to use Command Pattern, because every command knows how to undo itself, so we don't have to store multiple snapshots of an object. For example, think of the resize operation; If a user resizes a video, we only have to store the previous dimentsion dimension of the video; not the entire snapshot of the video object. (The Command Pattern stores a history of executed commands, which can be more memory efficient, especially if the commands themselves are lightweight)

                        _________________        ________________
                        | ItalicCommand |        | HtmlDocument |
                        |_______________|<>----->|______________|
                        | preConvert:   |        | makeItalic() |
                        |_______________|        |______________|
                        | execute()     |
                        | unexecute()   |
                        |_______________|
                                ^
                                v
                                |
                                |
                                v
                        ___________               ________________
                        | History |<------------<>| UndoCommand  |
                        |_________|               |______________|
                        |         |               | execute()    |
                        |_________|               |______________|

                - A new class, UndoCommand has been created to handle all undo operations. It pops the last command from History, then calls unexecute() on that command, as all commands know how to unexecute themselves


    - COMMAND PATTERN UML: From GoF book:
                    _____________________             _____________________
                    |  Invoker          |             |  Command          |
                    |___________________|<>---------->|___________________|
                    |                   |             |  next()           |
                    |___________________|             |___________________|
                                                            ^
                                                            |
                                                            |
                    _____________________          _____________________
                    |  Receiver         |          |  ConcreteCommand  |
                    |___________________|<---------|___________________|-|
                    |                   |          |  next()           | |-|
                    |___________________|          |___________________| | |
                                                     |___________________| |
                                                       |___________________|


    - When to use the Command Pattern:
        - Use the COmmand Pattern when you want to implement reversible operations, because it uses less RAM thatn the Memento Pattern which has to backup the whole state of the object
        - The Command Pattern is great when you want to queue operations, or schedule their execution, as command objects can be serialized (converted into strings) and stored in databases or sent over networks, then at a later time, they can be converted back into objects and executed



    - Pros and Cons:
        + Satifies SRP; classes that invoke operations are decoupled from classes that perform these operations
        + Satifies Open/closed principle: new commands can be added to the codebase without having to modify existing code

        - Code may become more complex as you're adding a new layer between senders and receivers

 */

public class Notes {

}
