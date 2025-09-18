package _04_DesignPatterns.Behavioral.Command.good;

public class TurnOffCommand implements Command {

    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
