package _03_Design.Behavior.Command;

import java.util.ArrayDeque;
import java.util.Deque;

/*

    NOTES:
    - Is a behavioral pattern that converts a request into an object with all neccessary information about the request
    - Key players:
        - Command interface
        - Concrete Command
        - Invoker
        - Receiver

    - Example:
        - HTMLDOC
        - Undo
        - Light&Bulb

*/

public class _01_Command {
    public static void main(String[] args) {
        _Light light = new _Light();

        _RemoteControl remoteControl = new _RemoteControl(new _LightOn(light));
        remoteControl.press();
        System.out.println();

        remoteControl.setCommand(new _LightDim(light));
        remoteControl.press();
        System.out.println();

        remoteControl.setCommand(new _LightOff(light));
        remoteControl.press();
    }
}

interface _Command {
    void execute();
}

class _Light {

    public void turnOn() {
        System.out.println("Light turned On");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }

    public void turnDim() {
        System.out.println("Light Dimmed");
    }
}

class _RemoteControl {

    private _Command command;

    public _RemoteControl(_Command command) {
        this.command = command;
    }

    public void setCommand(_Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }
}

class _LightOn implements _Command {
    private _Light light;

    public _LightOn(_Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class _LightOff implements _Command {
    private _Light light;

    public _LightOff(_Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class _LightDim implements _Command {
    private _Light light;

    public _LightDim(_Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnDim();
    }
}

// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------

class _1_Notes {
    public static void main(String[] args) {

        __HTMLDoc htmlDoc = new __HTMLDoc();
        __History history = new __History();

        htmlDoc.content = "Crazy world";
        System.out.println(htmlDoc.content);
        System.out.println();

        __ItalicCommand italicCommand = new __ItalicCommand(history, htmlDoc);
        italicCommand.execute();
        System.out.println(htmlDoc.content);
        System.out.println();

        __BoldCommand boldCommand = new __BoldCommand(history, htmlDoc);
        boldCommand.execute();
        System.out.println(htmlDoc.content);
        System.out.println();

        __AddTextCommand texCommand = new __AddTextCommand(history, htmlDoc, "text ");
        texCommand.execute();
        System.out.println(htmlDoc.content);
        System.out.println();

        __undoCommand undoCommand = new __undoCommand(history);
        undoCommand.execute();
        System.out.println(htmlDoc.content);
        System.out.println();

        undoCommand.execute();
        System.out.println(htmlDoc.content);
        System.out.println();

    }
}

interface __Command {
    void execute();
}

interface __ReverseCommand extends __Command {
    void unexecute();
}

class __HTMLDoc {

    public String content;

    public String italic() {
        return "<i>" + content + "</i>";
    }

    public String bold() {
        return "<b>" + content + "</b>";
    }

    public String addString(String text) {
        return content + " " + text;
    }
}

class __History {

    private Deque<__ReverseCommand> reverseCommands = new ArrayDeque<>();

    public void add(__ReverseCommand reverseCommand) {
        reverseCommands.push(reverseCommand);
    }

    public __ReverseCommand pop() {
        if (reverseCommands.isEmpty())
            return null;
        return reverseCommands.pop();
    }
}

class __undoCommand implements __Command {

    private __History history;

    public __undoCommand(__History history) {
        this.history = history;
    }

    public void undo() {
        __ReverseCommand prevCommand = history.pop();
        prevCommand.unexecute();
    }

    @Override
    public void execute() {
        undo();
    }
}

class __ItalicCommand implements __ReverseCommand {

    private String prevContent;

    private __History history;
    private __HTMLDoc htmlDoc;

    public __ItalicCommand(__History history, __HTMLDoc htmlDoc) {
        this.history = history;
        this.htmlDoc = htmlDoc;
    }

    @Override
    public void execute() {
        prevContent = htmlDoc.content;
        htmlDoc.content = htmlDoc.italic();
        history.add(this);
    }

    @Override
    public void unexecute() {
        htmlDoc.content = prevContent;
    }
}

class __BoldCommand implements __ReverseCommand {

    private String prevContent;

    private __History history;
    private __HTMLDoc htmlDoc;

    public __BoldCommand(__History history, __HTMLDoc htmlDoc) {
        this.history = history;
        this.htmlDoc = htmlDoc;
    }

    @Override
    public void execute() {
        prevContent = htmlDoc.content;
        htmlDoc.content = htmlDoc.bold();
        history.add(this);
    }

    @Override
    public void unexecute() {
        htmlDoc.content = prevContent;
    }
}

class __AddTextCommand implements __ReverseCommand {

    private String prevContent;
    private String text;

    private __History history;
    private __HTMLDoc htmlDoc;

    public __AddTextCommand(__History history, __HTMLDoc htmlDoc, String text) {
        this.history = history;
        this.htmlDoc = htmlDoc;
        this.text = text;
    }

    @Override
    public void execute() {
        prevContent = htmlDoc.content;
        htmlDoc.content = htmlDoc.addString(text);
        history.add(this);
    }

    @Override
    public void unexecute() {
        htmlDoc.content = prevContent;
    }
}
