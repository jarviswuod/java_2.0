package _04_DesignPatterns.Behavioral.Command;

/*

    NOTES:
    - The Command Pattern is a behavioral design pattern that encapsulates a request as an object, allowing you to parameterize clients with queues, requests, or operations.

    It enables you to decouple the sender from the receiver, providing flexibility in the execution of commmands and supporting undoable operations

    - BAD SOLUTION:

                |--------------------------|             |-------------------|
                |  RemoteControl           |             |  Light            |
                |--------------------------|<>---------->|-------------------|
                |  - light                 |             |  + turnOn()       |
                |--------------------------|             |  + turnOff()      |
                |  + pressButton(turnOn)   |             |  + dim()          |
                |  + dimLight()            |             |-------------------|
                |--------------------------|

        - Light is tightly coupled to RemoteControl. If we want to add new features, then we have to modify RemoteControl

    - COMMAND PATTERN UML:

            |--------------------|             |-------------------|
            |  RemoteControl     |             |  Command          |
            |--------------------|<>---------->|-------------------|
            |  - command         |             |  + execute()      |
            |--------------------|             |-------------------|
            |  + pressButton()   |                      |
            |--------------------|                      |
                                                        |
                                        |----------------------------------|
                                        |                                  |
                                        V                                  V
         |--------------|          |--------------------|     |--------------------|
         |  Light       |          |  TurnOn            |     |  TurnOff           |
         |--------------|<--|      |--------------------|     |--------------------|
         |  + turnOn()  |   |      |  - light           |     |  - light           |
         |  + turnOff() |   |      |--------------------|     |--------------------|
         |  + dim()     |   |      |  + execute()       |     |  + execute()       |
         |--------------|   |      |--------------------|     |--------------------|
                            |                    |                           |
                            |____________________|___________________________|

    - Using the Command Pattern, we decouple RemoteControl, the 'sender' from Light, the 'receiver'. To add new fucntionality, such as dimming the light, we extend out codebase by adding a new Dim command, without having to modify RemoteControl. The RemoteControl is composed of 'Command'. The concrete commands, TurnOn and TurnOff, implement Command, store a reference to Light

    - The Command Pattern is also commonly used in UI frameworks, especially for handling user interactions with buttons or menu items. Each button or menu item can be associalted wit a specific commsnd object, allwoing the framework to execute the appropriate action when the user intereacts with the UI element. This decouples the UI components from the actual operations they perform facilitating features like undo/redo as and event logging in UI application


   
            |---------------|             |-------------------|
            |  Button       |             |  Command          |
            |---------------|<>---------->|-------------------|
            |  - command    |             |  + execute()      |
            |---------------|             |-------------------|
            |  + click()    |                      ^
            |---------------|                      |
     FRAMEWORK:                                    |
     ______________________________________________|_____________________
     APP:                                          |
                                            |-------------------|
            |-------------------|           |  AddUser          |
            |  UserService      |           |-------------------|
            |-------------------|<----------|  - userService    |
            |  + addUser()      |           |-------------------|
            |-------------------|           |  + execute()      |
                                            |-------------------|

        
        - The 'FRAMEWORK' would be code that you couldn't edit, i.e some UI package, and the 'APP' that you create. YOu would create concrete commands that extend the Command interface found in the UI package. Your concrete commands keep a a reference to a class that contains the business logic, such as UserService, which contains methods related to adding, updating, and deleting users

        - A simpler solution, without the Command pattern, would be to create a load of Button subclasses for each place where a button is used. These subclasses would contain the code for what should happen when that button is clicked

                                |---------------|
                                |  Button       |
                                |---------------|

            |---------------|  |---------------|   |---------------|   |---------------|                                           
            | AddUserButton |  |CloseWindowBtn |   |  SaveButton   |   |  PrintButton  |                                           
            |---------------|  |---------------|   |---------------|   |---------------|   

          |---------------|  |---------------|   |---------------|   |---------------|                                           
          | BrightButton  |  | OpenWindowBtn |   |  CutButton    |   |  CopyButton   |                                           
          |---------------|  |---------------|   |---------------|   |---------------|   

        - Problems:
            - Could end up with a huge number of subclasses. This would be OK if there was no risk of breaking the code in these subclasses every time the base Button class is modified - but if we update our UI library and it includes a breaking change to the button class, then it could break all our button classes. This is a fragile solution.

            - Some operations, such as "Copy" need to be called from multiple places. Example;
                - A user can click the copy button, press "Ctrl + C" or right-click and select 'copy' logic from the context menu. With this solution, we'd either have to duplicate the copy logic in multiple classes, or make shortcuts and context menus dependent on buttons, whih is a very bad solution

        - The Command Pattern solves this issue b breaking the app into layers, following the good software desgn principl called "principle of separation of concerns". The Command Pattern breaks the app into two layers; the GUI is responsible for rendering things on the screen, capturing user input, and showing results. Then when it comes to the Important stuff, such as validating the info from a contact form and sending an email, the GUI delegates that task to the underlying layer of business logic

        - GoF UML:

                |-------------------|             |-------------------|
                |  Invoker          |             |  Command          |
                |-------------------|<>---------->|-------------------|
                |                   |             |  next()           |
                |-------------------|             |-------------------|
                                                        ^
                                                        |
                                                  |-------------------|
                |-------------------|             |  ConcreteCommand  |
                |  Receiver         |<------------|-------------------|-|
                |-------------------|             |  next()           | |-|
                |                   |             |-------------------| | |
                |-------------------|               |-------------------| |
                                                      |-------------------|
        -  Command Pattern with Undo functionality:
            Another common use case for the Command Pattern is to implement undo functionality. By storing a history of executed commands, you can easily reverse the effects of previous operations

                |-------------------|
                |  Command          |
                |-------------------|
                |  + execute()      |
                |-------------------|
                        ^            
                        |            
                        |            
                |-------------------|
                |  UndoCommand      |
                |-------------------|
                |  + unexecute()    |
                |-------------------|
                        ^
                        |
                        |
                |-------------------|
                |  ItalicCommand    |
                |-------------------|
                |  + execute()      |
                |  + unexecute()    |
                |-------------------|
        - Above , we creat a new interface class called UndoCommand, which iextends Command; this is because undoable commmands are still. Why not add the unexecute() method to the Command interface? Because not all commands are undoable. Some commands, such as sending an email or processing a payment, may not have a meaningful undo operation

        - We can then create concrete command classes, such as ItalicCommand, that implement both execute() and unexecute() methods. The execute() method applies the italic formatting, while the unexecute() method removes it

        - We can also use the Memento Patten to implement undo mechanisms. THe difference between Memento and Command patterns when it comes to undo operations is Memento, we store the changes in the state of an object i.e. we keep multiple snapshots over time. Sometimes, storing these snapshots can be memory intensive, especially if the object's state is large or complex(videos are large and consume loads of memory). 
        - In those conditions, it;s better to use Command Pattern, because every command knows how to undo itself, so we don't have to store multiple snapshots of an object. For example, think of the resize operation; If a user resizes a video, we only have to store the previous dimentsion dimension of the video; not the entire snapshot of the video object. (The Command Pattern stores a history of executed commands, which can be more memory efficient, especially if the commands themselves are lightweight)
        

                |-------------------|             |-------------------|
                |  ItalicCommand    |             |  HtmlDocument     |
                |-------------------|<>---------->|-------------------|
                |  - preConvert:    |             |  + makeItalic()   |
                |-------------------|             |-------------------|
                |  + execute()      |
                |  + unexecute()    |
                |-------------------|
                           ^
                           |
                           |
                           ^
                           v                      |-------------------|
                |-------------------|             |  UndoCommand      |
                |  History          |<----------<>|-------------------|
                |-------------------|             |  + execute()      |
                |                   |             |-------------------|
                |-------------------|

        - A new class, UndoCommand has been created to handle all undo operations. It pops the last command from History, then calls unexecute() on that command, as all commands know how to unexecute themselves

        - When to use the Command Pattern
            - Use the COmmand Pattern when you want to implement reversible operations, because it uses less RAM thatn the Memento Pattern which has to backup the whole state of the object

            - The Command Pattern is great when you want to queue operations, or schedule their execution, as command objects can be serialized (converted into strings) and stored in databases or sent over networks, then at a later time, they can be converted back into objects and executed

        - Pros and Cons:
            + Satifies SRP; classes that invoke operations are decoupled from classes that perform these operations
            + Satifies Open/closed principle: new commands can be added to the codebase without having to modify existing code

            - COde may become more complex as you're adding a new layer between senders and receivers

 */

public class Notes {

}
