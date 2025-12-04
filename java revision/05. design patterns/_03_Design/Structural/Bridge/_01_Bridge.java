package _03_Design.Structural.Bridge;

/*

    NOTES:
    - Is a structural design pattern that separates abstraction from implementation where now they can gro independently
    - Key players:
        - Abstraction
        - Implementation interface
        - Concrete Implementation

    - Example:
        - Remote control

*/

public class _01_Bridge {
    public static void main(String[] args) {

        RemoteControl_ remote = new RemoteControl_(new LGRadio_());
        remote.turnOn();
        remote.volumeUp();

        AdvancedRemote_ advanced = new AdvancedRemote_(new SonyTv_());
        advanced.turnOn();
        advanced.changeChannel(89);
    }
}

interface Device_ {

    void turnOn();

    void turnOff();

    void volumeUp();

    void volumeDown();

    void changeChannel(int channel);
}

class RemoteControl_ {

    protected Device_ device;

    public RemoteControl_(Device_ device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void volumeUp() {
        device.volumeUp();
    }

    public void volumeDown() {
        device.volumeDown();
    }
}

class AdvancedRemote_ extends RemoteControl_ {

    public AdvancedRemote_(Device_ device) {
        super(device);
    }

    public void changeChannel(int channel) {
        device.changeChannel(channel);
    }
}

class LGRadio_ implements Device_ {

    @Override
    public void turnOn() {
        System.out.println("*Lg Radio* turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("*Lg Radio* turned Off");
    }

    @Override
    public void volumeUp() {
        System.out.println("*Lg Radio* volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("*Lg Radio* volume Down");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("*Lg Radio* Channel changed " + channel);
    }
}

class SonyTv_ implements Device_ {

    @Override
    public void turnOn() {
        System.out.println("**Sony Tv turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("**Sony Tv turned Off");
    }

    @Override
    public void volumeUp() {
        System.out.println("**Sony Tv volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("**Sony Tv volume Down");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("**Sony Tv Channel changed " + channel);
    }
}