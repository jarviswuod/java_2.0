package _04_DesignPatterns.Structural.Bridge.bad;

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
