package _04_DesignPatterns.Structural.Bridge.good;

public class LGRadio implements Device {

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

    @Override
    public void setChannel(int channel) {
        System.out.println("Setting LG radio Channel to " + channel);
    }
}
