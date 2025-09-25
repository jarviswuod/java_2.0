package _04_DesignPatterns.Creational.AbstractFactory.good.UIWindows;

import _04_DesignPatterns.Creational.AbstractFactory.good.Button;

public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Windows: render button");
    }
}
