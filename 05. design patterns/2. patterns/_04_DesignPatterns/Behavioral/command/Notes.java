package _04_DesignPatterns.Behavioral.command;

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
        


 */

public class Notes {

}
