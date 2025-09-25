package _04_DesignPatterns.Creational.AbstractFactory.good;

import _04_DesignPatterns.Creational.AbstractFactory.good.UIWindows.WindowsButton;
import _04_DesignPatterns.Creational.AbstractFactory.good.UIWindows.WindowsCheckBox;

public class WindowsUIComponentFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
