package _04_AbstractFactoryDesignPattern.os.win;

import _04_AbstractFactoryDesignPattern.Button;

public class WinButton implements Button {

    @Override
    public void paint() {
        System.out.println("Win button");
    }
}
