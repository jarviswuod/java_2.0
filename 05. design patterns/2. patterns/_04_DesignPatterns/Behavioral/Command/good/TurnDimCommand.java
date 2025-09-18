package _04_DesignPatterns.Behavioral.Command.good;

public class TurnDimCommand implements ICommand {

    private Light light;

    public TurnDimCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.dim();
    }

}
