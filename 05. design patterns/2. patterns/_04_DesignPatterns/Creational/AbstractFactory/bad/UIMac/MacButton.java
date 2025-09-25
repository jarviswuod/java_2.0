package _04_DesignPatterns.Creational.AbstractFactory.bad.UIMac;

import _04_DesignPatterns.Creational.AbstractFactory.bad.Button;

public class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Mac: render button");
    }
}
