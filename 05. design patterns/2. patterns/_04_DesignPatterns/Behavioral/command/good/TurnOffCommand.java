package _04_DesignPatterns.Behavioral.command.good;

public class TurnOffCommand implements ICommand {

    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

}
