package _04_AbstractFactory.uifactory;

import _04_AbstractFactory.Button;
import _04_AbstractFactory.Checkbox;

public interface UIFactory {

    Button createBUtton();

    Checkbox createCheckbox();
}
