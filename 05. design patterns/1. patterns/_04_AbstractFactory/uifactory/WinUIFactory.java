package _04_AbstractFactory.uifactory;

import _04_AbstractFactory.Button;
import _04_AbstractFactory.Checkbox;
import _04_AbstractFactory.os.win.WinButton;
import _04_AbstractFactory.os.win.WinCheckbox;

public class WinUIFactory implements UIFactory {

    @Override
    public Button createBUtton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
