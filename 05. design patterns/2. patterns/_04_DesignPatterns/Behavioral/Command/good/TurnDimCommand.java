package _04_DesignPatterns.Behavioral.Command.good;

public class TurnDimCommand implements Command {

    private Light light;

    public TurnDimCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.dim();
    }
}
