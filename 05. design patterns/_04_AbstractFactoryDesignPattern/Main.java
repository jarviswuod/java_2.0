package _04_AbstractFactoryDesignPattern;

import _04_AbstractFactoryDesignPattern.uifactory.MacUIFactory;
import _04_AbstractFactoryDesignPattern.uifactory.WinUIFactory;

public class Main {
    public static void main(String[] args) {
        Application application = new Application(new WinUIFactory());
        Application application2 = new Application(new MacUIFactory());
        application.paint();
        application2.paint();
    }
}
