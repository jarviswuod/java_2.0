package _04_AbstractFactory;

import _04_AbstractFactory.uifactory.UIFactory;

public class Application {

    private Button button;
    private Checkbox checkbox;

    public Application(UIFactory factory) {
        button = factory.createBUtton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
