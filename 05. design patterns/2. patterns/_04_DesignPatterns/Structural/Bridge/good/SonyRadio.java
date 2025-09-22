package _04_DesignPatterns.Structural.Bridge.good;

public class SonyRadio implements Device {

    @Override
    public void turnOn() {
        System.out.println("Turning Sony radio on");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Sony radio off");
    }

    @Override
    public void volumeUp() {
        System.out.println("Turning Sony radio volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Turning Sony radio volume down");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Setting Sony radio Channel to " + channel);
    }
}
