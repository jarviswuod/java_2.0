package _04_AbstractFactoryDesignPattern.os.win;

import _04_AbstractFactoryDesignPattern.Checkbox;

public class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Win Checkbox");
    }
}
