package _03_Design.Behavior.Command;

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

    }
}
