package _04_DesignPatterns.Behavioral.Command;

/*

    NOTES:
    - We are creating a remote control that if connected to lights, it can either be swicthed on or off.

    - Light class: Receiver class
        - THis is a standard class with two methods on() and off()
        - This method is refered to as a receiver it's receiving from the remote

                public class Light {

                    public void turnOn() {
                        System.out.println("Light is ON");
                    }

                    public void turnOff() {
                        System.out.println("Light is OFF");
                    }
                }

    - RemoteControl class: Invoker class
        - This is our invoker, its invoking some commands to or Ligt class which is the receiving class
        - Here we will store a reference to the Light and set the Light in the Constructor

                public class RemoteControl {

                    private Light light;

                    public RemoteControl(Light light) {
                        this.light = light;
                    }
                    
                    ...
                }

        - We will have another methods called pressButton() having one parameter which determines whether the light should be turned on or off
            - If the parameter is true, we will call the turnOn() method of the Light class
            - If the parameter is false, we will call the turnOff() method of the Light class

                    public class RemoteControl {

                        public void pressButton(boolean turnOn) {
                            if (turnOn) {
                                light.turnOn();
                            } else {
                                light.turnOff();
                            }
                        }

                        ...
                    }



    - Main class: Client class:
        - In remoteConctrol we pass the lisght we want to control
                public class Main {
                    public static void main(String[] args) {
                        Light light = new Light();
                        RemoteControl remote = new RemoteControl(light);

                        remote.pressButton(true);  // Output: Light is ON
                        remote.pressButton(false); // Output: Light is OFF
                    }
                }


    - ISSUES:
        - We have some issues with this solution. example, the RemovteControl class directly calls methods on the conrete class object. This is direct coupling between Light and RemoteControl makes it hard to extend the functionality or to introduce new commands without modifying the RemoteCotnrol class. Example ; we can want to add the fucntiality to Dim the light or change its color. This would require us to modify the RemoteControl class, which violates the open-closed principle

                    public class RemoteControl {

                        public void DimLight() {
                            light.dimLight();

                            ...
                        }

                        public void ChangeColor(Color color) {
                            if (color == Color.RED) {
                                light.colorChange();
                            } else if (color == Color.BLUE) {
                                light.colorChange();
                            }

                            ...
                        }

                        ...
                    }

            - CURRENT SOLUTION UML: tight coupling issue here
                        ____________________________             _____________________
                        |  RemoteControl           |             |  Light            |
                        |__________________________|<>---------->|___________________|
                        |  - light                 |             |  + turnOn()       |
                        |__________________________|             |  + turnOff()      |
                        |  + pressButton(turnOn)   |             |  + dim()          |
                        |  + dimLight()            |             |___________________|
                        |__________________________|


    - SOLUTION: COMMAND PATTERN
        - We will be implementing our RemoteControl and Light class using the Command Pattern

        - COmmand interface: COmmand
            - First we create Command interface which has one method called execute()

                    public interface Command {

                        void execute();
                    }

        - RemoteControl class;INvoker class
            - It stores a reference to the command object(COmposed). We then pass the Command to the Contructor
                    public class RemoteControl {

                        private Command command;

                        public RemoteControl(Command command) {
                            this.command = command;
                        }

                        ...
                    }


            - We will add a setter for the command so we can change the command at any time (to swap commands at run time) 
                    public class RemoteControl {

                        public void setCommand(Command command) {
                            this.command = command;
                        }

                        ...
                    }

            - We will then have our pressButton() method which will call the execute() method in the command object. It will execute watever command we have passed to our RemoteCotnrol

                    public class RemoteControl {

                        public void pressButton() {
                            command.execute();
                        }

                        ...
                    }

        - Light class: REceiver class
            - Its the same thing as we had before in the first solution(bad solution) with turnOn() turnOff() and also a dim() method as we can dim light as well

                    public class Light {

                        public void turnOn() {
                            System.out.println("Light is ON");
                        }

                        public void turnOff() {
                            System.out.println("Light is OFF");
                        }

                        public void dim() {
                            System.out.println("Light is Dim");
                        }
                    }


        - Then we can createa concrete command implemetning the Command interface

            - TurnOnCommand class:
                - we need to store a reference to the object we are kind of controling in this case Light class after which we pass it into the constructor.
                - THe light field can only be set in the Constructor but cannot be added into  any setter methods basically the command it immutable( cannot be changed once created)

                    public class TurnOnCommand implements Command {

                        private Light light;

                        public TurnOnCommand(Light light) {
                            this.light = light;
                        }

                        ...
                    }

                - FOr our execute method we simply call the turnOn() method on the light object


                    public class TurnOnCommand implements Command {

                        @Override
                        public void execute() {
                            light.turnOn();
                        }

                        ...
                    }

            - Same case happens on our TurnOffCommand and DimCommand concrete classes

        - Main class: Client
            - We want to interact with our solution as a client
            - First we instanciate the Light object
            - THen we also create our RemoteCOntrol object which takes in a Command interface conrete class say we can pass in TurnOnCommand() which takes in light object
            - THen we press the button;  if you press the button the RemoteControl is gion got execute the turnOn command


                    public class Main {

                        public static void main(String[] args) {

                            Light light = new Light();

                            RemoteControl remoteControl = new RemoteControl(new TurnOnCommand(light));
                            remoteControl.pressButton();

                            ...
                        }
                    }

            - We can also dim the light if it's too bright, we just call the setCommand and pass in the DimComand which also takes in light, and if we press the button, the command is executed


                public class Main {

                    public static void main(String[] args) {

                        Light light = new Light();

                        RemoteControl remoteControl = new RemoteControl(new TurnOnCommand(light));

                        remoteControl.setCommand(new TurnDimCommand(light));
                        remoteControl.pressButton();

                        ...
                    }
                }

        - We have lots of flexibility in terms of what we command to use and whenever we want to create a new command or fucntionality for our remote, we can simpliy extend our codebase by create a concrete command   wihtout havin to touch our invoker class(RemoteControl class)



    - UNDO WITH COMMAND PATTERN:
        - HTMLDocument class:
            - In this class, this is where we are going to implement our business, logic, this clas will know nothing about commands as it's simpley the layer of our business application

            - We have both fields "content" and makeItalic() method

                    public class HtmlDocument {

                        public String content;

                        public void makeItalic() {
                            content = "<i>" + content + "</i>";
                        }
                    }

            - We have a makeItalic() method is we can have our business logic, the content wrapped in Html italic tags


        - Command Interface:
            - THis is an interface with the execute() method and we will also create the undoable interface which extends the command interface with unexecute() method
                    public interface Command {

                        void execute();
                    }


                    public interface UndoableCommand extends Command {

                        void unexecute();
                    }

        - Command Histroy class:
            - It keeps track of the commands that we have applied
            - It has a Deque list to help with the commands stroage
            - The we have push() method which will allow us to easily interact with the History class
                - the size() methods is used for getting th esize of the current length the command list(usefule in another class)
                - The push() method takes in command as parameter which will added to the Deque
                - The pop() method helps us with removing the last command item on the Command list returning th last item
                    - get 
                    - remove 
                    - return


                    public class History {

                        private Deque<UndoableCommand> commands = new ArrayDeque<>();

                        public void push(UndoableCommand command) {
                            commands.push(command);
                        }

                        public UndoableCommand pop() {
                            if (commands.isEmpty()) {
                                return null;
                            }
                            return commands.pop();
                        }

                        public int size() {
                            return commands.size();
                        }
                    }

        - Concrete italic command:
            - It implements the UndoableCommand Interface where we have both execute and unexecute methods
            - We need some fields to store 1. the reference to the HTMLDocuments

            - We also need a field for the previous content which is intialized to an empty string
            - we also need reference to store the Histroy object
            - After that we ned the constructor which takes in the HTMLDocuement and History classes

                    public class ItalicCommand implements UndoableCommand {

                        private HtmlDocument document;
                        private String prevContent = "";
                        private History history;

                        public ItalicCommand(HtmlDocument document, History history) {
                            this.document = document;
                            this.history = history;
                        }

                        ...
                    }

            - We also need to implement the execute and unecxecute methods
                - WHen we execute we ened the curent HTMLDoc content set to a prevcontent and then push this command objhect to the History class
                    - get current content from HtmlDoc,  soting it to the prevContnt 
                    - we then make the content italic 
                    - Then push  this command object onto the Histroy list

                    public class ItalicCommand implements UndoableCommand {

                        @Override
                        public void execute() {
                            prevContent = document.content;
                            document.makeItalic(); // delegate work to the doc business object
                            history.push(this);
                        }

                        ...
                    }

                - for the unexecute() method
                    - al we do is to go back to what content was before we executed the command; pretty stragith forward

                    public class ItalicCommand implements UndoableCommand {

                        @Override
                        public void unexecute() {
                            document.content = prevContent;
                        }

                        ...
                    }

        - UndoCommand:
            - THis class sort of manages all of the undoable commands
                - It implements the COmmand interface, 
                - It needs to store a areference to  History which is also pass though the constructor


                - In the undo() method, we will check if histroyhas any item/commands in the list and then if it does then we can pop the last item/command of the list and then call it's execute method

                    public class UndoCommand implements Command {

                        private History history;

                        public UndoCommand(History history) {
                            this.history = history;
                        }

                        @Override
                        public void execute() {
                            if (history.size() > 0) {
                                UndoableCommand lastCommand = history.pop();
                                lastCommand.unexecute(); // Deegating the undo logic to undoable command object
                            }
                        }
                    }


        - Main class: Client:
            - This is simiulating how our solution will interact with the client object;
                - first is to create HTMlDoc instance
                - THen create Histroy object 
                - setting the HtmlDOc content
                - Finally logging the content


                    public class Main {
                        public static void main(String[] args) {

                            HtmlDocument htmlDoc = new HtmlDocument();
                            History history = new History();

                            htmlDoc.content = "Hello World";
                            System.out.println(htmlDoc.content); // Hello World

                            ...
                        }
                    }

            - Next is making the content Italic
                - Create an italicCommand object and we pass in the HtmlDoc and the Histroy object
                - we then call the execute command on the ItalicCommand
                - Log the content

                    public class Main {
                        public static void main(String[] args) {

                            HtmlDocument htmlDoc = new HtmlDocument();
                            History history = new History();

                            ItalicCommand italicCommand = new ItalicCommand(htmlDoc, history);
                            italicCommand.execute();
                            System.out.println(htmlDoc.content); // <i>Hello World</i>

                            ...
                        }
                    }


            - Last thing is to test the undo funcionality:
                - Create an UndoCommand object and we pass in the Histroy object
                - we then call the execute command on the ItalicCommand
                - Log the content

                    public class Main {
                        public static void main(String[] args) {

                            HtmlDocument htmlDoc = new HtmlDocument();
                            History history = new History();

                            UndoCommand undoCommand = new UndoCommand(history);
                            undoCommand.execute();
                            System.out.println(htmlDoc.content); // Hello World

                            ...
                        }
                    }
        
        
        

 */

public class Explanation {

}
