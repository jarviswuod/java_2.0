package _04_DesignPatterns.Behavioral.command.bad;

public class Main {

    public static void main(String[] args) {

        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl(light);

        remoteControl.pressButton(true);
        remoteControl.pressButton(false);
    }
}
