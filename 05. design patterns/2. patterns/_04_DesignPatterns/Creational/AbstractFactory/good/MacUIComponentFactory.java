package _04_DesignPatterns.Creational.AbstractFactory.good;

import _04_DesignPatterns.Creational.AbstractFactory.good.UIMac.MacButton;
import _04_DesignPatterns.Creational.AbstractFactory.good.UIMac.MacCheckBox;

public class MacUIComponentFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
