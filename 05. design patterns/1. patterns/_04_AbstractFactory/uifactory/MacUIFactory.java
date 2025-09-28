package _04_AbstractFactory.uifactory;

import _04_AbstractFactory.Button;
import _04_AbstractFactory.Checkbox;
import _04_AbstractFactory.os.mac.MacButton;
import _04_AbstractFactory.os.mac.MacCheckbox;

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