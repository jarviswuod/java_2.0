package _04_DesignPatterns.Creational.AbstractFactory.good.UIWindows;

import _04_DesignPatterns.Creational.AbstractFactory.good.CheckBox;

public class WindowsCheckBox implements CheckBox {

    @Override
    public void render() {
        System.out.println("Windows: render Checkbox");
    }
}
