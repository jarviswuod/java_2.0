package _04_DesignPatterns.Structural.Bridge.good;

public class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void setChannel(int channel) {
        System.out.println("Setting channel to " + channel);
    }
}
