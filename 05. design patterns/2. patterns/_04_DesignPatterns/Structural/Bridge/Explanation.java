package _04_DesignPatterns.Structural.Bridge;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have a remote controlling a radio. There are multiple different brands of radio with different types of remotes. How would we design a solution for this?


    - SOLUTION 1:
        - RemoteControl class:
            - We have a base control class which is an abstract class with 4 methods of controlling a radio
                    public abstract class RemoteControl {

                        public abstract void turnOn();

                        public abstract void turnOff();

                        public abstract void volumeUp();

                        public abstract void volumeDown();
                    }


        - AdvancedRemote class:
            - This is also an abstract class that extends the abstract RemoteControl class
            - We add an extra method over here setChannel(int channel) which takes in an interger of the channel number that we want to set our radio to
                    public abstract class AdvancedRemote extends RemoteControl {

                        public abstract void setChannel(int channel);
                    }


        - RadioAndTVRemote class:
            - This is also an abstract class extending the abstract RemoteControl class
            - We are having 2 extra abstract methods controlTV() to control the tv and controlRadio() to control the radio essentially we can select which ever device we want to control

                    public abstract class RadioAndTvRemote extends RemoteControl {

                        public abstract void controlTV();

                        public abstract void controlRadio();
                    }


        - Concrete classes:
            - We will implement the RemoteControl types for LG devices ignoring sony and samsung devices for demo

            - LGRemote class:
                - We extend the RemoteControl abstract classs then implement turnOn(), turnOff(), volumeDown(), and volumeUp()

                    public class LGRemote extends RemoteControl {

                        @Override
                        public void turnOn() {
                            System.out.println("Turning LG radio on");
                        }

                        ...
                    }


            - AdvancedLGRemote class:
                - We extend the AdvancedRemote abstract class and implement setChannel(), turnOn(), turnOff(), volumeUp(), and volumeDown()

                    public class AdvancedLGRemote extends AdvancedRemote {

                        @Override
                        public void setChannel(int channel) {
                            System.out.println("Setting LG channel to " + channel);
                        }
                    }


            - LGRadioAndTVRemote class:
                - We extend the RadioAndTVRemote class and implement controlTV(), controlRadio(), turnOn(), turnOff(), volumeUp(), and volumeDown()

                    public class LGRadioAndTVRemote extends RadioAndTvRemote {

                        @Override
                        public void controlTV() {
                            System.out.println("Now Controlling LG TV");
                        }
                    }



        - Main class: Client class;
            - We create LGRemote object and then turn on the radio

            - We create LGRadioAndTVLGRemote object and we call the methods controlTV(), turnOn() and volumeUp()
                    public class Main {
                        public static void main(String[] args) {

                            LGRemote lgRemote = new LGRemote();
                            lgRemote.turnOn();
                            lgRemote.turnOff();

                            System.out.println();

                            LGRadioAndTVRemote lgRadioAndTVRemote = new LGRadioAndTVRemote();
                            lgRadioAndTVRemote.controlRadio();
                            lgRadioAndTVRemote.turnOn();
                            lgRadioAndTVRemote.volumeUp();
                        }
                    }



        - Observation:
            - This solution is very inflexible because every time we add a new remote type we'll need to create a new classes for every brand of TV and Radio. Also everytime we add a new brand we'll need to create a new class for every remote type
            - The reason we end up with this solution is because our hierarchy is growing into 2 dimesions, abstact dimension or the remote type and an implementaion dimension



    - SOLUTION 2: BRIDGE PATTERN:
        - Device interface:
            - It defines all the methods a device should have
            - It has 5 methods turnOn(), turnOff(), volumeUp(), volumeDown() and setChannel()

                    public interface Device {

                        public void turnOn();

                        public void turnOff();

                        public void volumeUp();

                        public void volumeDown();

                        public void setChannel(int channel);
                    }


        - RemoteControl class:
            - Next up is creating our base RemoteControl class
            - It needs to be composed of device hence we have a field storing Device object and then we pass the device into the RemoteControl via the constructor
            - We then define what a basic RemoteControl class should do, turnOn(), turnOff(), volumeUp() and volumeDown() methods
            - If turnOn() method calls device.turnOn() this is because all devices will have a turnOn() method with them
            - Same thing to turnOff() method
            - NOTE:
                - This class doesnot matter what the brand is weather it's LG, Sony or Samsung this is because it's coded to the device interface and we can simply call the methods on the device without checking what the brand of the device is, we are using polymorphism which makes nice, flexible and easy

                        public class RemoteControl {

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



        - AdvancedRemote class:
            - We also create our advancedRemote control class
            - It extends our base RemoteControl and we need access to a constructor and pass up a device up to our super RemoteControl class
            - The AdvancedRemote class can do everything a RemoteControl class can do, but then it can also set a channel using setChannel() method passing an integer number

                    public class AdvancedRemote extends RemoteControl {

                        public AdvancedRemote(Device device) {
                            super(device);
                        }

                        public void setChannel(int channel) {
                            System.out.println("Setting channel to " + channel);
                        }
                    }



        - Concrete device classes:
            - LGRadio class:
                - It implements the Device interface with all it's methods
                - NOTE:
                    - We are not worried about whether this is gonna be advanced device or a regular base sort of device. The remote type is no longer related to the device

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


            - SonyRadio class:
                - It implements Device interface and it's methods
                - Same concept applies here

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



        - Main class: Client class:
            - First we create an LGRemoteControl object using the RemoteControl class, you need to pass the device you are going to control (The brand of the device you want to control)
            - Then call turnOn() and turnOff() methods on the RemoteControl object
            - NOTE:
                - We have 2 separate hierarchies, we have the remoteType(device brand controlled) which is separate from the brand or the device type(LGRadio)
                        new RemoteControl(new LGRadio);

                - Previously we were sort of combining them into subclasses i.e LGRadioAndTVRemote(), RadioAndTVRemote is the remote type and LG is the brand
            
            - We can also create an advancedSony remote control with new AdvancedRemote() and we pass the device/brand we want to control new SonyRadio()
                        new AdvancedRemote(new SonyRadio);

            - We then call turnOn(), turnOff() and also setChannel() to set a different channel


            - NOTE: Our RemoteControl class is now delegating the work to the device via bridge and the bridge is basically a composition [[[ RemoteControl { private Device device; } ]]] this can now grow independently from each other

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

 */

public class Explanation {

}