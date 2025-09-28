package _04_AbstractFactory;

import _04_AbstractFactory.uifactory.MacUIFactory;
import _04_AbstractFactory.uifactory.WinUIFactory;

public class Main {
    public static void main(String[] args) {

        Application application = new Application(new WinUIFactory());
        Application application2 = new Application(new MacUIFactory());
        application.paint();
        application2.paint();
    }
}
