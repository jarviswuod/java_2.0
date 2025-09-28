package _04_AbstractFactory.os.mac;

import _04_AbstractFactory.Checkbox;

public class MacCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Mac Checkbox");
    }
}
