package _04_DesignPatterns.Behavioral.Command;

/*

    NOTES:
    - Command Pattern:
        - Is a pattern that turns a request into a stand-alone object that contains all information about the request
        - This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations


    - CHALLENGE:
        - Consider a situation where we are creating a remote control that is connected to light and the light can either be switched on or off


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



    - SOLUTION 2: Using the Command Pattern:
        - Using the Command pattern we decouple RemoteControl class(sender) from Light class(receiver). Then, to add new functionality such as dimming the light, we just extend our codebase by adding a new DimCommand class without having to modify RemoteControl class
        - The concrete command classes TurnOn and TurnOff implement Command and store a reference to Light. The RemoteControl is composed of Command

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
                _____________         _____________      _____________
                | Light     |         | TurnOn    |      | TurnOff   |
                |___________|<--|     |___________|      |___________|
                | turnOn()  |   |     | light     |      | light     |
                | turnOff() |   |     |___________|      |___________|
                | dim()     |   |     | execute() |      | execute() |
                |___________|   |     |___________|      |___________|
                                |___________|__________________|



    - UNDO WITH COMMAND PATTERN:
        - The Command Pattern is used in UI frameworks especially when handling user interactions with a UI element. In this case each UI element can be associated with a specific command object allowing the framework to execute the appropriate action when the user interacts with the element. This decouples the UI elements from the actual operations they are performing on facilitating features like undo/redo as and event is logged in UI application

                ____________________           ______________
                | Button           |           | Command    |
                |__________________|<>-------->|____________|
                | command: Command |           | execute()  |
                |__________________|           |____________|
                | click()          |                 ^
                |__________________|                 |
                                                     |                 FRAMEWORK:
            _________________________________________|___________________________
                                                     |                       APP:
                                              _______________
                    _______________           | AddUser     |
                    | UserService |           |_____________|
                    |_____________|<----------| userService |
                    | addUser()   |           |_____________|
                    |_____________|           | execute()   |
                                              |_____________|


        - The 'FRAMEWORK' is code that can't be editted i.e code from a UI package while the 'APP' is code that we create
        - We create concrete commands by extending the Command interface from the UI package. Your concrete commands keeps reference to the class that contains the business logic such as UserService which contains methods related to adding, updating, and deleting users



        - Undo feature without Command pattern:
            - Performing undo without the Command pattern would be creating a load of Button subclasses for each place where a button is used. These subclasses would contain the code for what should happen when that button is clicked

                                        _________________
                                        |  Button       |
                                        |_______________|

                _________________  __________________   _________________   _________________
                | AddUserButton |  | CloseWindowBtn |   |  SaveButton   |   |  PrintButton  |
                |_______________|  |________________|   |_______________|   |_______________|

                _________________  _________________   _________________   _________________
                | BrightButton  |  | OpenWindowBtn |   |  CutButton    |   |  CopyButton   |
                |_______________|  |_______________|   |_______________|   |_______________|


            - ISSUE:
                - This is a fragile solution as one ends up with a huge number of subclasses which would be OK if there was no risk of breaking the code in these subclasses every time the base Button class is modified. But, if we have updates our UI library and it includes a breaking change to the Button class then it could break all our button subclasses

                - Another issue is duplicate logic i.e Some operations such as "Copy" need to be called from multiple places say when a user clicks the copy button, press "Ctrl + C" or right-click and select 'copy' logic from the context menu



        - UNDO feature with COMMAND PATTERN:
            - The Command Pattern can be used to implement undo functionality. By storing a history of executed commands you can easily reverse the effects of previous operations
            - The Command Pattern breaks the APP into two layers;
                1. The GUI which is responsible for rendering what's on screen, capturing user input, and showing results
                2. Business logic used when it comes to the important stuff such as validating info from a contact form or sending an email

            
                    _________________           _________________           _________________
                    | Command       |           | UndoCommand   |           | ItalicCommand |
                    |_______________|<----------|_______________|<----------|_______________|
                    | execute()     |           | unexecute()   |           | execute()     |
                    |_______________|           |_______________|           | unexecute()   |
                                                                            |_______________|


                - Above, we create UndoCommand interface which implements Command interface this is because commands such as sending an email or processing a payment are undoable

                - We then create concrete command classes such as ItalicCommand from the UndoCommand interface to implement both execute() and unexecute() methods where execute() applies the italic formatting while unexecute() removes it


            - We can also use the Memento Patten to implement undo feature the difference is
                - In Memento we store the changes in the state of an object meaning we keep multiple snapshots over time. Storing these snapshots can be memory intensive especially if the object's state are large and complex example videos

                - In Command Pattern every command knows how to undo itself meaning we don't have to store multiple snapshots of an object making it a good solution over Memento. Example, think of the resize operation;
                    - If a user resizes a video, we only have to store the previous dimensions of the video and not the entire snapshot of the video object. In this case the Command Pattern stores a history of executed commands which can be more memory efficient especially if the commands themselves are lightweight

                            _________________        ________________
                            | ItalicCommand |        | HtmlDocument |
                            |_______________|<>----->|______________|
                            | preConvert:   |        | makeItalic() |
                            |_______________|        |______________|
                            | execute()     |
                            | unexecute()   |        ______________             ________________
                            |_______________|<>----->| History    |<----------<>| UndoCommand  |
                                                     |____________|             |______________|
                                                     |            |             | execute()    |
                                                     |____________|             |______________|



    - COMMAND PATTERN UML: From GoF book:
                    ______________             _____________
                    | Invoker    |             | Command   |
                    |____________|<>---------->|___________|
                    |            |             | next()    |
                    |____________|             |___________|
                                                    ^
                                                    |
                                                    |
                    _______________          ____________________
                    | Receiver    |          | ConcreteCommand  |
                    |_____________|<---------|__________________|-|
                    |             |          | next()           | |-|
                    |_____________|          |__________________| | |
                                              |___________________| |
                                                |___________________|


    - When to use the Command Pattern:
        - Use the Command Pattern when you want to implement reversible operation as it uses less RAM than Memento Pattern which has to backup the whole state of the object
        - The Command Pattern is great when you want to queue operations or schedule their execution for command objects can be serialized (converted to string) and stored in databases or sent over networks then at a later time they can be converted back into objects and executed


    - Pros and Cons:
        + Satifies SRP; classes that invoke operations are decoupled from classes that perform these operations
        + Satifies OCP; new commands can be added to the codebase without having to modify existing code

        - Code may become more complex as there's an additionally layer between senders and receivers

 */

public class Notes {

}
