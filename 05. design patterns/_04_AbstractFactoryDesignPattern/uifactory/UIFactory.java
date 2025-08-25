package _04_AbstractFactoryDesignPattern.uifactory;

import _04_AbstractFactoryDesignPattern.Button;
import _04_AbstractFactoryDesignPattern.Checkbox;

public interface UIFactory {

    Button createBUtton();

    Checkbox createCheckbox();

}
