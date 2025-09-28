package _04_AbstractFactory.os.win;

import _04_AbstractFactory.Checkbox;

public class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Win Checkbox");
    }
}
