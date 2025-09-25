package _04_DesignPatterns.Creational.AbstractFactory.bad.UIMac;

import _04_DesignPatterns.Creational.AbstractFactory.bad.CheckBox;

public class MacCheckBox implements CheckBox {

    @Override
    public void render() {
        System.out.println("Mac: render Checkbox");
    }
}
