package _04_DesignPatterns.Creational.AbstractFactory.good.UIMac;

import _04_DesignPatterns.Creational.AbstractFactory.good.Button;

public class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Mac: render button");
    }
}
