package _04_DesignPatterns.Behavioral.Command.bad;

// Invoker
public class RemoteControl {

    private Light light;

    public RemoteControl(Light light) {
        this.light = light;
    }

    public void pressButton(boolean turnOn) {
        if (turnOn) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }
}
