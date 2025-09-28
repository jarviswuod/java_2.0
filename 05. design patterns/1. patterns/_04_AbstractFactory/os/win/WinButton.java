package _04_AbstractFactory.os.win;

import _04_AbstractFactory.Button;

public class WinButton implements Button {

    @Override
    public void paint() {
        System.out.println("Win button");
    }
}
