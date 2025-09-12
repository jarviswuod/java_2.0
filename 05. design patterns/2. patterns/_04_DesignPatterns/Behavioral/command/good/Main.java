package _04_DesignPatterns.Behavioral.command.good;

public class Main {

    public static void main(String[] args) {

        Light light = new Light();

        RemoteControl remoteControl = new RemoteControl(new TurnOnCommand(light));
        remoteControl.pressButton();

        remoteControl.setCommand(new TurnDimCommand(light));
        remoteControl.pressButton();

        remoteControl.setCommand(new TurnOffCommand(light));
        remoteControl.pressButton();
    }
}
