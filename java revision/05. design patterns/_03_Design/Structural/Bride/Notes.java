package _03_Design.Structural.Bride;

/*

    NOTES:
    - Is a structural design pattern that separates abstraction from implementation to allow changes happen to each independently

    - 3 key players:
        - Abstraction
        - Implementation
        - Concrete implementation

    - FIRST ATTEMPT ::: ::: :::

            public class Notes {
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

            interface Device {

                public void turnOn();

                public void turnOff();

                public void volumeUp();

                public void volumeDown();

                public void setChannel(int channel);
            }

            class RemoteControl {

                private Device device;

                public RemoteControl(Device device) {
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

            class AdvancedRemote extends RemoteControl {

                public AdvancedRemote(Device device) {
                    super(device);
                }

                public void setChannel(int channel) {
                    System.out.println("Setting channel to " + channel);
                }
            }

            class LGRadio implements Device {

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

            class SonyRadio implements Device {

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

*/

public class Notes {
    public static void main(String[] args) {

    }
}
