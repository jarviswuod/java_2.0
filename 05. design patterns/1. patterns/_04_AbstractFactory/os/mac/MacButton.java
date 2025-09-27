package _04_AbstractFactoryDesignPattern.os.mac;

import _04_AbstractFactoryDesignPattern.Button;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Mac Button");
    }

}
