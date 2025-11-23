package _04_DesignPatterns.Structural.Bridge.good;

public class Main {
    public static void main(String[] args) {

        RemoteControl lgRemoteControl = new RemoteControl(new LGRadio());
        lgRemoteControl.turnOn();
        lgRemoteControl.turnOff();

        System.out.println();

        AdvancedRemote advancedRemote = new AdvancedRemote(new SonyRadio());
        advancedRemote.turnOn();
        advancedRemote.turnOff();
        advancedRemote.setChannel(4);
    }
}
