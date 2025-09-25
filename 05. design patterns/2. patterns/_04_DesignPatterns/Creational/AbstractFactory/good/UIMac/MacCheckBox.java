package _04_DesignPatterns.Creational.AbstractFactory.good.UIMac;

import _04_DesignPatterns.Creational.AbstractFactory.good.CheckBox;

public class MacCheckBox implements CheckBox {

    @Override
    public void render() {
        System.out.println("Mac: render Checkbox");
    }
}
