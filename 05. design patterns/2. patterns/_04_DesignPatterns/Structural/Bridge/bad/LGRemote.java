package _04_DesignPatterns.Structural.Bridge.bad;

public class LGRemote extends RemoteControl {

    @Override
    public void turnOn() {
        System.out.println("Turning LG radio on");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning LG radio off");
    }

    @Override
    public void volumeUp() {
        System.out.println("Turning LG radio volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Turning LG radio volume down");
    }
}
