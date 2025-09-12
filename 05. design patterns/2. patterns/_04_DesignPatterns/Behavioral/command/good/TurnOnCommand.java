package _04_DesignPatterns.Behavioral.command.good;

public class TurnOnCommand implements ICommand {

    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

}
