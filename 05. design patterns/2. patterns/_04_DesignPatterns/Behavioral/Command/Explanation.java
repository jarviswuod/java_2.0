package _04_DesignPatterns.Behavioral.Command;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Consider a situation where we are creating a remote control that is connected to light and the light can either be switched on or off


    - SOLUTION 1:
        - Light class: Receiver class
            - This is a standard class with two methods turnOn() and turnOff()
            - This class is referred to as a receiver as it's receiving from the RemoteControl class

                    public class Light {
                        public void turnOn() {
                            System.out.println("Light is ON");
                        }

                        public void turnOff() {
                            System.out.println("Light is OFF");
                        }
                    }


        - RemoteControl class: Invoker class
            - This class invokes commands to Light class which is our receiving class
            - Here we will store a reference to the Light and set the Light in the Constructor

                    public class RemoteControl {
                        private Light light;

                        public RemoteControl(Light light) {
                            this.light = light;
                        }
                        
                        ...
                    }


            - We have pressButton() method taking one parameter that determines whether the light should be turned on or off i.e If the parameter is true we call the turnOn() method of the Light class else we call turnOff()

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
            - In RemoteControl we pass the light we want to control
                    public class Main {
                        public static void main(String[] args) {

                            Light light = new Light();
                            RemoteControl remote = new RemoteControl(light);

                            remote.pressButton(true);  // Output: Light is ON
                            remote.pressButton(false); // Output: Light is OFF
                        }
                    }


        - ISSUES:
            - We have some issues with this solution;
                - The RemoteControl class directly calls methods on the concrete class object. This is direct coupling between Light and RemoteControl making it hard to extend the functionality or to introduce new commands without modifying the RemoteControl class
                    - If we can want to add the functionality to Dim the light or change it's color. This would require us to modify the RemoteControl class violating the OCP

                        public class RemoteControl {

                            public void DimLight() {
                                light.dimLight();

                                ...
                            }

                            public void ChangeColor(Color color) {
                                if (color == Color.RED) {
                                    light.colorChange();
                                }

                                ...
                            }

                            ...
                        }


        - CURRENT SOLUTION UML: tight coupling issue here

                    _______________________             ______________
                    | RemoteControl       |             | Light      |
                    |_____________________|<>---------->|____________|
                    | light: Light        |             | turnOn()   |
                    |_____________________|             | turnOff()  |
                    | pressButton(turnOn) |             | dim()      |
                    | dimLight()          |             |____________|
                    |_____________________|




    - SOLUTION 2: COMMAND PATTERN
        - Let's implement our RemoteControl and Light class using the Command Pattern

        - Command interface: Command
            - First we create Command interface which has one method called execute()

                    public interface Command {

                        void execute();
                    }


        - RemoteControl class: Invoker class;
            - It stores a reference to the command object(Composed). We then pass the Command to the Contructor
            - We add a setter for the command so we can change the command at runtime
                    public class RemoteControl {

                        private Command command;

                        public RemoteControl(Command command) {
                            this.command = command;
                        }

                        public void setCommand(Command command) {
                            this.command = command;
                        }

                        ...
                    }


            - We will then have our pressButton() method which will call the execute() method in the command object. It will execute whatever command we have passed to our RemoteControl

                    public class RemoteControl {

                        public void pressButton() {
                            command.execute();
                        }

                        ...
                    }


        - Light class: Receiver class
            - It's the same thing as we had before in the first/bad solution with turnOn() turnOff() also added dim() method as we can dim light as well

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


        - Concrete Command interface;
            - TurnOnCommand class:
                - we need to store a reference to the object we are kind of controling in this case Light class after which we pass it into the constructor
                - The light field can only be set in the Constructor ahs no setters allowed making the command immutable (cannot be changed once created)
                - For our execute method we simply call the turnOn() method on the light object

                        public class TurnOnCommand implements Command {

                            private Light light;

                            public TurnOnCommand(Light light) {
                                this.light = light;
                            }

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
            - Then create RemoteControl object which takes in a Command interface's concrete class say we pass in TurnOnCommand() which takes in light object
            - Then we class pressButton() method which executes the turnOn() command
            - We can also dim the light if it's too bright, we just call the setCommand() method and pass in the new DimCommand object which also takes in light. If we then call pressButton() method the command is executed

                    public class Main {
                        public static void main(String[] args) {

                            Light light = new Light();

                            RemoteControl remoteControl = new RemoteControl(new TurnOnCommand(light));
                            remoteControl.pressButton();


                            remoteControl.setCommand(new TurnDimCommand(light));
                            remoteControl.pressButton();

                            ...
                        }
                    }


        - OBSERVATION:
            - We have lots of flexibility in terms of what command to use and whenever we want to create a new command or functionality for our remote we simply extend our codebase by creating a concrete command without having to touch our invoker class(RemoteControl class)




    - UNDO WITH COMMAND PATTERN:
        - HTMLDocument class: Receiver
            - This is where we implement our business logic
                - NOTE
                    - This class will know nothing about commands as it's simply a layer of our business application

            - We have "content" fields and makeItalic() method
            - In makeItalic() method we have our business logic i.e our "content" field is wrapped in Html italic tags

                    public class HtmlDocument {
                        public String content;

                        public void makeItalic() {
                            content = "<i>" + content + "</i>";
                        }
                    }


        - Command Interface:
            - This is an interface with the execute() method
                    public interface Command {

                        void execute();
                    }


        - UndoableCommand Interface:
            - We create the UndoableCommand interface by extending the command interface
            - We introduce unexecute() method

                    public interface UndoableCommand extends Command {

                        void unexecute();
                    }


        - History class: Invoker
            - It keeps track of the commands that we have applied using a Deque for UndoableCommand commands storage
            - The push() method allows us to easily interact with the History class
            - The size() methods is used for getting the size of the current length the command list(useful in another class)
            - The push() method takes in command as parameter which will added to the Deque
            - The pop() method helps in removing the last command item on the Command list returning the last item

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


        - Concrete command class
            - UndoCommand class:
                - This class sort of manages all of the undoable commands
                    - It implements the Command interface
                    - It needs to store a reference to History which is also pass through the constructor

                    - Under undo() method we will check if history has any item/commands in the list and then if it does we can pop the last item/command of the list and then call it's execute method

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



            - ItalicCommand class:
                - It implements the UndoableCommand Interface where we have both execute and unexecute methods
                - We need some fields to store
                    - The reference to the HTMLDocuments
                    - We also need a field for the previous content which is intialized to an empty string
                    - we also need reference to store the History object

                - After that we need the constructor which takes in the HTMLDocuement and History classes

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


                - We also need to implement the execute() and unexecute() methods
                    - When we execute we need the curent HTMLDocument content set to a prevContent and then push this command object to the History class
                        - Get current content from HtmlDoc, sorting it to the prevContent 
                        - We then make the content italic 
                        - Then push this command object onto the History list

                                public class ItalicCommand implements UndoableCommand {

                                    @Override
                                    public void execute() {
                                        prevContent = document.content;
                                        document.makeItalic(); // delegate work to the doc business object
                                        history.push(this);
                                    }

                                    ...
                                }


                    - For the unexecute() method
                        - All we do is to go back to what content was before we executed the command

                                public class ItalicCommand implements UndoableCommand {

                                    @Override
                                    public void unexecute() {
                                        document.content = prevContent;
                                    }

                                    ...
                                }



        - Main class: Client class;
            - This is simulating how our solution will interact with the client object;
                - First is to create HTMlDocument instance
                - Then create History object 
                - Setting the HTMlDocument content
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
                - Create an ItalicCommand object and we pass in the HTMlDocument and the History object
                - We then call the execute command on the ItalicCommand
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


            - Last thing is to testing the undo functionality:
                - Create an UndoCommand object and we pass in the History object
                - We then call the execute command on the ItalicCommand
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
