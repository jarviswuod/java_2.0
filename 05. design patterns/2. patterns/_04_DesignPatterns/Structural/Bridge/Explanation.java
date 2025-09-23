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

 */

public class Explanation {

}