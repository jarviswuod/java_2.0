package _04_DesignPatterns.Structural.Bridge.bad;

public class AdvancedLGRemote extends AdvancedRemote {

    @Override
    public void setChannel(int channel) {
        System.out.println("Setting LG channel to " + channel);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning LG radio On");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning LG radio Off");
    }

    @Override
    public void volumeUp() {
        System.out.println("Turning LG radio volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Turning LG radio volume Down");
    }
}
