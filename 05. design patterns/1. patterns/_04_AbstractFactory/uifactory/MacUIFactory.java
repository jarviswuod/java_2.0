package _04_AbstractFactoryDesignPattern.uifactory;

import _04_AbstractFactoryDesignPattern.Button;
import _04_AbstractFactoryDesignPattern.Checkbox;
import _04_AbstractFactoryDesignPattern.os.mac.MacButton;
import _04_AbstractFactoryDesignPattern.os.mac.MacCheckbox;

public class MacUIFactory implements UIFactory {

    @Override
    public Button createBUtton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}