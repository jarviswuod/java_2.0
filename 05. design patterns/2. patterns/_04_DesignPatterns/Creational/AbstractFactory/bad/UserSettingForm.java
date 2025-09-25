package _04_DesignPatterns.Creational.AbstractFactory.bad;

import _04_DesignPatterns.Creational.AbstractFactory.bad.UIMac.MacButton;
import _04_DesignPatterns.Creational.AbstractFactory.bad.UIMac.MacCheckBox;
import _04_DesignPatterns.Creational.AbstractFactory.bad.UIWindows.WindowsButton;
import _04_DesignPatterns.Creational.AbstractFactory.bad.UIWindows.WindowsCheckBox;

public class UserSettingForm {

    public void render(OperatingSystemType os) {
        if (os == OperatingSystemType.Windows) {
            new WindowsButton().render();
            new WindowsCheckBox().render();
        } else if (os == OperatingSystemType.Mac) {
            new MacButton().render();
            new MacCheckBox().render();
        } else {

        }
    }
}
