package _04_AbstractFactoryDesignPattern.uifactory;

import _04_AbstractFactoryDesignPattern.Button;
import _04_AbstractFactoryDesignPattern.Checkbox;
import _04_AbstractFactoryDesignPattern.os.win.WinButton;
import _04_AbstractFactoryDesignPattern.os.win.WinCheckbox;

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
