package _04_AbstractFactory.os.mac;

import _04_AbstractFactory.Button;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Mac Button");
    }
}
