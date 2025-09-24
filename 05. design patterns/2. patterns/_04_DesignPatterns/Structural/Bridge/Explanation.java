package _04_DesignPatterns.Structural.Bridge;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have a remote controlling a radio. There are multiple different brands of radio, and there are different types of remotes


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
            - This is an abstract class too and extends the abstract the RemoteControl class
            - We add an extra method over here setChannel(int channel) which takes in an interger of the channel number that we want to set our radio to
                    public abstract class AdvancedRemote extends RemoteControl {

                        public abstract void setChannel(int channel);
                    }


        - RadioAndTVRemote class:
            - This is also an abstract class extending the abstract RemoteControl class
            - We are having 2 extra abstract methods controlTV() and controlRadio() -  we can select which device we want to control - controlTV to control the tv and call the controlRadio() to control the radio

                    public abstract class RadioAndTvRemote extends RemoteControl {

                        public abstract void controlTV();

                        public abstract void controlRadio();
                    }


        - Concrete classes;
            - We will implement the Remote control types for LG devices basically ignoring sony and samsung devices just for demo

            - LGRemote class;
                - We extend the RemoteControl abstract classs then override the methods; turnOn(), turnOff(), volumeDown(), and volumeUp()

                    public class LGRemote extends RemoteControl {

                        @Override
                        public void turnOn() {
                            System.out.println("Turning LG radio on");
                        }

                        ...
                    }


            - AdvancedLGRemote class;
                - We extend the AdvancedRemote abstract class and implement all the methods; setChannel(), turnOn(), turnOff(), volumeUp(), and volumeDown()

                    public class AdvancedLGRemote extends AdvancedRemote {

                        @Override
                        public void setChannel(int channel) {
                            System.out.println("Setting LG channel to " + channel);
                        }
                    }


            - LGRadioAndTVRemote class;
                - We extend the RadioAndTVRemote class and implement the methods; controlTV(), controlRadio(), turnOn(), turnOff(), volumeUp(), and volumeDown()

                    public class LGRadioAndTVRemote extends RadioAndTvRemote {

                        @Override
                        public void controlTV() {
                            System.out.println("Now Controlling LG TV");
                        }
                    }


        - Main class; Client class;
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
            - This solution is very inflexible because every time we add a new remote type, we need to create a new class for every brand of TV and everytime we add a new brand, we need to create a new class for every remote type
            - The reason we endded with this solution is because is because our hierarchy is growing into 2 dimesions, abstact dimension or the remote type and an implementaion dimension which is the



    - SOLUTION 2: BRIDGE PATTERN;
        - Device interface:
            - It defines all the methods a decive should have
            - This is the first interface and it has 3 methods, turnOn, turnOff and setChannel()

        - RemoteControl class:
            - Next up is creating our base remote control class
            - It needs to be composed of device hence we have a field storing devide object and then we pass the device into the RemoteControl via the constructor
            - We then define what a basic RemoteControl class should do, turnOn(), turnOff() we will keep it simple and only have the 2 but we can also have volumeUp() and volumeDown() methods too
            - So for example turnOn() method we will call device.turnOn() this is because all devices will have a turnOn() method with them
            - Same thing to turnOff() method
            - NOTE: This class doesnot matter what the brand is weather it's LG, Sony or Samsung this is because it's coded to the device interface and we can simply call the methods on the device without checking what the brand of the device is, we are using polymorphism which makes nice, flexible and easy


        - AdvancedRemote class:
            - We also create our advancedRemoteControl class
            - It extends our base remote control and we need access to a constructor and pass up a device up to our super RemoteControl class.
            - The AdvancedRemote class can do everything a RemoteControl class can do, but then it can also set a channel using setChannel() method passing an integer number

        - Concrete device classes:
            - LGRadio class:
                - It implements the Device interface and implements it's methods too
                - NOTE: we are not worried about whether this is gonna be advanced device or a regular base sort of device. The remote type is nolonger related to the device

            - SonyRadio class:
                - it implements the Device interface and implements it's methods too
                - Same concept applies here


        - Main class: Client class;
            - First we create an LGRemoteControl object using the RemoteControl class, you need to pass the device you are going to control - the brand of the device you want to control
            - Then we call the methods turnOn() or turnOff() on the RemoteControl object
            - NOTE: We have 2 separate hierarchies, we have the remoteType(RemoteControl) which is separater from the brand or the device type(LGRadio)
                    new RemoteControl(new LGRadio);

            - Previously we were sort of combining them into subclasses. example; LGRadioAndTVRemote(), RadioAndTVRemote is the remote type and LG is the brand
            
            - We can also create an advancedSony remote control with new AdvancedRemote() and we pass the device/brand we want to control new SonyRadio()
                    new AdvancedRemote(new SonyRadio);

                - We can then call turnOn(), turnOff() and also setChannel() to set a different channel


            - NOTE: Our RemoteControl class is now delegating the work to the device via bridge and the bridge is basically composition RemoteControl,.,.,. private Device device;.... this can now grow independtly from each other

 */

public class Explanation {

}