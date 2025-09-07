package _04_AbstractFactoryDesignPattern.os.mac;

import _04_AbstractFactoryDesignPattern.Checkbox;

public class MacCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Mac Checkbox");
    }

}
