package _03_Design.Behavior.Command;

/*

    NOTES:
    - Is a behavioral pattern that converts a request into an object with every information about the request

    - Key players:
        - Command interface
        - Concrete command
        - Invoker
        - Receiver

    - Example:
        - Light bulb challenge


    - COMMAND PATTERN ::: ::: ::: :::

            public class Notes {
                public static void main(String[] args) {

                    Light light = new Light();

                    RemoteControl remoteControl = new RemoteControl(new TurnOnCommand(light));
                    remoteControl.pressButton();

                    remoteControl.setCommand(new DimLightCommand(light));
                    remoteControl.pressButton();

                    remoteControl.setCommand(new TurnOffCommand(light));
                    remoteControl.pressButton();
                }
            }

            interface Command {

                void execute();
            }

            class RemoteControl {

                private Command command;

                public RemoteControl(Command command) {
                    this.command = command;
                }

                public void setCommand(Command command) {
                    this.command = command;
                }

                public void pressButton() {
                    command.execute();
                }
            }

            class Light {

                public void turnOn() {
                    System.out.println("Lights turned on");
                }

                public void turnOff() {
                    System.out.println("Lights turned off");
                }

                public void dimLight() {
                    System.out.println("Lights dimmed");
                }
            }

            class TurnOnCommand implements Command {

                private Light light;

                public TurnOnCommand(Light light) {
                    this.light = light;
                }

                @Override
                public void execute() {
                    light.turnOn();
                }
            }

            class TurnOffCommand implements Command {

                private Light light;

                public TurnOffCommand(Light light) {
                    this.light = light;
                }

                @Override
                public void execute() {
                    light.turnOff();
                }
            }

            class DimLightCommand implements Command {

                private Light light;

                public DimLightCommand(Light light) {
                    this.light = light;
                }

                @Override
                public void execute() {
                    light.dimLight();
                }
            }


 */

public class Notes {
    public static void main(String[] args) {

    }
}
