package _03_Design.Behavior.Command;

import java.util.ArrayDeque;
import java.util.Deque;

/*

    NOTES:
    - Is a behavioral pattern that converts a request into an object with every information about the request

    - Key players:
        - Command interface
        - Concrete command
        - Invoker
        - Receiver

    - Example:
        - Light bulb challenge


    - COMMAND PATTERN ::: ::: ::: :::

            public class Notes {
                public static void main(String[] args) {

                    Light light = new Light();

                    RemoteControl remoteControl = new RemoteControl(new TurnOnCommand(light));
                    remoteControl.pressButton();

                    remoteControl.setCommand(new DimLightCommand(light));
                    remoteControl.pressButton();

                    remoteControl.setCommand(new TurnOffCommand(light));
                    remoteControl.pressButton();
                }
            }

            interface Command {

                void execute();
            }

            class RemoteControl {

                private Command command;

                public RemoteControl(Command command) {
                    this.command = command;
                }

                public void setCommand(Command command) {
                    this.command = command;
                }

                public void pressButton() {
                    command.execute();
                }
            }

            class Light {

                public void turnOn() {
                    System.out.println("Lights turned on");
                }

                public void turnOff() {
                    System.out.println("Lights turned off");
                }

                public void dimLight() {
                    System.out.println("Lights dimmed");
                }
            }

            class TurnOnCommand implements Command {

                private Light light;

                public TurnOnCommand(Light light) {
                    this.light = light;
                }

                @Override
                public void execute() {
                    light.turnOn();
                }
            }

            class TurnOffCommand implements Command {

                private Light light;

                public TurnOffCommand(Light light) {
                    this.light = light;
                }

                @Override
                public void execute() {
                    light.turnOff();
                }
            }

            class DimLightCommand implements Command {

                private Light light;

                public DimLightCommand(Light light) {
                    this.light = light;
                }

                @Override
                public void execute() {
                    light.dimLight();
                }
            }



    - UNDO PATTERN ::: ::: ::: :::

            public class Notes {
                public static void main(String[] args) {

                    HtmlDocument htmlDoc = new HtmlDocument();
                    History history = new History();

                    htmlDoc.content = "Hello World";
                    System.out.println(htmlDoc.content); // Hello World

                    ItalicCommand italicCommand = new ItalicCommand(htmlDoc, history);
                    italicCommand.execute();
                    System.out.println(htmlDoc.content); // <i>Hello World</i>

                    UndoCommand undoCommand = new UndoCommand(history);
                    undoCommand.execute();
                    System.out.println(htmlDoc.content); // Hello World
                }
            }

            class HtmlDocument {
                public String content;

                public void makeItalic() {
                    content = "<i>" + content + "</i>";
                }
            }

            interface Command {

                void execute();
            }

            interface UndoableCommand extends Command {

                void unexecute();
            }

            class History {

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

            class UndoCommand implements Command {

                private History history;

                public UndoCommand(History history) {
                    this.history = history;
                }

                @Override
                public void execute() {
                    if (history.size() > 0) {

                        UndoableCommand lastCommand = history.pop();
                        lastCommand.unexecute(); // Delegating the undo logic to undoable command object
                    }
                }
            }

            class ItalicCommand implements UndoableCommand {

                private HtmlDocument document;
                private String prevContent = "";
                private History history;

                public ItalicCommand(HtmlDocument document, History history) {
                    this.document = document;
                    this.history = history;
                }

                @Override
                public void execute() {
                    prevContent = document.content;
                    document.makeItalic(); // delegate work to the doc business object
                    history.push(this);
                }

                @Override
                public void unexecute() {
                    document.content = prevContent;
                }
            }


        - UNDO::: ::: ::: :::

            public class Notes {
                public static void main(String[] args) {

                    History history = new History();
                    HTMLDocument htmlDocument = new HTMLDocument();
                    ItalicCommand italicCommand = new ItalicCommand(history, htmlDocument);
                    BoldCommand boldCommand = new BoldCommand(history, htmlDocument);

                    System.out.println(htmlDocument.getContent());

                    italicCommand.execute();
                    System.out.println(htmlDocument.getContent());

                    boldCommand.execute();
                    System.out.println(htmlDocument.getContent());

                    UndoCommand undoCommand = new UndoCommand(history);
                    undoCommand.execute();
                    System.out.println(htmlDocument.getContent());

                    undoCommand.execute();
                    System.out.println(htmlDocument.getContent());

                }
            }

            interface Command {

                void execute();
            }

            interface UndoableCommand extends Command {

                void unexecute();
            }

            class History {

                private Deque<UndoableCommand> commands = new ArrayDeque<>();

                public void push(UndoableCommand cmd) {
                    commands.push(cmd);
                }

                public UndoableCommand pop() {
                    if (!commands.isEmpty())
                        return commands.pop();

                    return null;
                }
            }

            class HTMLDocument {

                private String content = "Hello Jarvis";

                public void makeItalic() {
                    setContent("<i>" + getContent() + "</i>");
                }

                public String getContent() {
                    return content;

                }

                public void setContent(String content) {
                    this.content = content;

                }

                public void makeBold() {
                    setContent("<b>" + getContent() + "</b>");
                }
            }

            class UndoCommand implements Command {

                private History history;

                public UndoCommand(History history) {
                    this.history = history;
                }

                @Override
                public void execute() {
                    history.pop().unexecute();
                }
            }

            class ItalicCommand implements UndoableCommand {

                private History history;
                private HTMLDocument htmlDocument;
                private String prevContent = "";

                public ItalicCommand(History history, HTMLDocument htmlDocument) {
                    this.history = history;
                    this.htmlDocument = htmlDocument;
                }

                @Override
                public void execute() {
                    prevContent = htmlDocument.getContent();
                    htmlDocument.makeItalic();
                    history.push(this);
                }

                @Override
                public void unexecute() {
                    htmlDocument.setContent(prevContent);
                }
            }

            class BoldCommand implements UndoableCommand {

                private History history;
                private HTMLDocument htmlDocument;
                private String prevContent = "";

                public BoldCommand(History history, HTMLDocument htmlDocument) {
                    this.history = history;
                    this.htmlDocument = htmlDocument;
                }

                @Override
                public void execute() {
                    prevContent = htmlDocument.getContent();
                    htmlDocument.makeBold();
                    history.push(this);
                }

                @Override
                public void unexecute() {
                    htmlDocument.setContent(prevContent);
                }
            }

 */

public class Notes {
    public static void main(String[] args) {

        Light__1 light = new Light__1();

        RemoteControl__1 remoteControl = new RemoteControl__1(new TurnOnCommand__1(light));
        remoteControl.pressButton();

        remoteControl.setCommand(new DimLightCommand__1(light));
        remoteControl.pressButton();

        remoteControl.setCommand(new TurnOffCommand__1(light));
        remoteControl.pressButton();
    }
}

interface Command__1 {

    void execute();
}

class RemoteControl__1 {

    private Command__1 command;

    public RemoteControl__1(Command__1 command) {
        this.command = command;
    }

    public void setCommand(Command__1 command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

class Light__1 {

    public void turnOn() {
        System.out.println("Lights turned on");
    }

    public void turnOff() {
        System.out.println("Lights turned off");
    }

    public void dimLight() {
        System.out.println("Lights dimmed");
    }
}

class TurnOnCommand__1 implements Command__1 {

    private Light__1 light;

    public TurnOnCommand__1(Light__1 light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand__1 implements Command__1 {

    private Light__1 light;

    public TurnOffCommand__1(Light__1 light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class DimLightCommand__1 implements Command__1 {

    private Light__1 light;

    public DimLightCommand__1(Light__1 light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.dimLight();
    }
}

// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------

class Notes_1 {
    public static void main(String[] args) {

        HtmlDocument_1 htmlDoc = new HtmlDocument_1();
        History_1 history = new History_1();

        htmlDoc.content = "Another World";
        System.out.println(htmlDoc.content); // Hello World

        ItalicCommand_1 italicCommand = new ItalicCommand_1(htmlDoc, history);
        italicCommand.execute();
        System.out.println(htmlDoc.content); // <i>Hello World</i>

        UndoCommand_1 undoCommand = new UndoCommand_1(history);
        undoCommand.execute();
        System.out.println(htmlDoc.content); // Hello World
    }
}

class HtmlDocument_1 {
    public String content;

    public void makeItalic() {
        content = "<i>" + content + "</i>";
    }
}

interface Command_1 {

    void execute();
}

interface UndoableCommand_1 extends Command_1 {

    void unexecute();
}

class History_1 {

    private Deque<UndoableCommand_1> commands = new ArrayDeque<>();

    public void push(UndoableCommand_1 command) {
        commands.push(command);
    }

    public UndoableCommand_1 pop() {
        if (commands.isEmpty()) {
            return null;
        }
        return commands.pop();
    }

    public int size() {
        return commands.size();
    }
}

class UndoCommand_1 implements Command_1 {

    private History_1 history;

    public UndoCommand_1(History_1 history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (history.size() > 0) {

            UndoableCommand_1 lastCommand = history.pop();
            lastCommand.unexecute(); // Delegating the undo logic to undoable command object
        }
    }
}

class ItalicCommand_1 implements UndoableCommand_1 {

    private HtmlDocument_1 document;
    private String prevContent = "";
    private History_1 history;

    public ItalicCommand_1(HtmlDocument_1 document, History_1 history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        prevContent = document.content;
        document.makeItalic(); // delegate work to the doc business object
        history.push(this);
    }

    @Override
    public void unexecute() {
        document.content = prevContent;
    }
}

// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------

class Notes_2 {
    public static void main(String[] args) {

        History_2 history = new History_2();
        HTMLDocument_2 htmlDocument = new HTMLDocument_2();
        ItalicCommand_2 italicCommand = new ItalicCommand_2(history, htmlDocument);
        BoldCommand_2 boldCommand = new BoldCommand_2(history, htmlDocument);

        System.out.println(htmlDocument.getContent());

        italicCommand.execute();
        System.out.println(htmlDocument.getContent());

        boldCommand.execute();
        System.out.println(htmlDocument.getContent());

        UndoCommand_2 undoCommand = new UndoCommand_2(history);
        undoCommand.execute();
        System.out.println(htmlDocument.getContent());

        undoCommand.execute();
        System.out.println(htmlDocument.getContent());

    }
}

interface Command_2 {

    void execute();
}

interface UndoableCommand_2 extends Command_2 {

    void unexecute();
}

class History_2 {

    private Deque<UndoableCommand_2> commands = new ArrayDeque<>();

    public void push(UndoableCommand_2 cmd) {
        commands.push(cmd);
    }

    public UndoableCommand_2 pop() {
        if (!commands.isEmpty())
            return commands.pop();

        return null;
    }
}

class HTMLDocument_2 {

    private String content = "Hello Jarvis";

    public void makeItalic() {
        setContent("<i>" + getContent() + "</i>");
    }

    public String getContent() {
        return content;

    }

    public void setContent(String content) {
        this.content = content;

    }

    public void makeBold() {
        setContent("<b>" + getContent() + "</b>");
    }
}

class UndoCommand_2 implements Command_2 {

    private History_2 history;

    public UndoCommand_2(History_2 history) {
        this.history = history;
    }

    @Override
    public void execute() {
        history.pop().unexecute();
    }
}

class ItalicCommand_2 implements UndoableCommand_2 {

    private History_2 history;
    private HTMLDocument_2 htmlDocument;
    private String prevContent = "";

    public ItalicCommand_2(History_2 history, HTMLDocument_2 htmlDocument) {
        this.history = history;
        this.htmlDocument = htmlDocument;
    }

    @Override
    public void execute() {
        prevContent = htmlDocument.getContent();
        htmlDocument.makeItalic();
        history.push(this);
    }

    @Override
    public void unexecute() {
        htmlDocument.setContent(prevContent);
    }
}

class BoldCommand_2 implements UndoableCommand_2 {

    private History_2 history;
    private HTMLDocument_2 htmlDocument;
    private String prevContent = "";

    public BoldCommand_2(History_2 history, HTMLDocument_2 htmlDocument) {
        this.history = history;
        this.htmlDocument = htmlDocument;
    }

    @Override
    public void execute() {
        prevContent = htmlDocument.getContent();
        htmlDocument.makeBold();
        history.push(this);
    }

    @Override
    public void unexecute() {
        htmlDocument.setContent(prevContent);
    }
}