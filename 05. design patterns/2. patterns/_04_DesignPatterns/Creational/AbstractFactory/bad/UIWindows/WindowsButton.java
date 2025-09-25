package _04_DesignPatterns.Creational.AbstractFactory.bad.UIWindows;

import _04_DesignPatterns.Creational.AbstractFactory.bad.Button;

public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Windows: render button");
    }
}
