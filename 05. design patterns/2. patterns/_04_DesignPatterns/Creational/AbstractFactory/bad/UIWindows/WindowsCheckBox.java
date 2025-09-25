package _04_DesignPatterns.Creational.AbstractFactory.bad.UIWindows;

import _04_DesignPatterns.Creational.AbstractFactory.bad.CheckBox;

public class WindowsCheckBox implements CheckBox {

    @Override
    public void render() {
        System.out.println("Windows: render Checkbox");
    }
}
