package _03_Design.Structural.Bridge;

/*

    NOTES:
    - Is a design that separates abstraction from implementation making everything grow on it's own
    - Key players:
        - Abstraction
        - Implementation
        - Concrete Implementation

    - Example:
        - Remote Control: TV and Radio

*/

public class _02_Bridge {
    public static void main(String[] args) {

        _02_LGRadio lgRadio = new _02_LGRadio();

        _02_Remote remote = new _02_Remote(lgRadio);
        remote.powerOn();
        remote.powerOff();
        remote.volumeUp();
        remote.volumeLow();

        _02_AdvancedRemote advanced = new _02_AdvancedRemote(lgRadio);
        advanced.setChannel(90);
        advanced.setChannel(940);

    }
}

interface _02_Device {

    void powerOn();

    void powerOff();

    void volumeUp();

    void volumeLow();

    void setChannel(int channel);
}

class _02_Remote {

    protected _02_Device device;

    public _02_Remote(_02_Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.powerOn();
    }

    public void powerOff() {
        device.powerOff();
    }

    public void volumeUp() {
        device.volumeUp();
    }

    public void volumeLow() {
        device.volumeLow();
    }
}

class _02_AdvancedRemote extends _02_Remote {

    public _02_AdvancedRemote(_02_Device device) {
        super(device);
    }

    public void setChannel(int channel) {
        device.setChannel(channel);
    }
}

class _02_SonyTv implements _02_Device {

    @Override
    public void powerOn() {
        System.out.println("Sony TV Device powerOn");
    }

    @Override
    public void powerOff() {
        System.out.println("Sony TV Device powerOff");
    }

    @Override
    public void volumeUp() {
        System.out.println("Sony TV Device volumeUp");
    }

    @Override
    public void volumeLow() {
        System.out.println("Sony TV Device volumeLow");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV Device setChannel " + channel);
    }
}

class _02_LGRadio implements _02_Device {

    @Override
    public void powerOn() {
        System.out.println("LG Radio Device powerOn");
    }

    @Override
    public void powerOff() {
        System.out.println("LG Radio Device powerOff");
    }

    @Override
    public void volumeUp() {
        System.out.println("LG Radio Device volumeUp");
    }

    @Override
    public void volumeLow() {
        System.out.println("LG Radio Device volumeLow");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("LG Radio Device setChannel " + channel);
    }
}