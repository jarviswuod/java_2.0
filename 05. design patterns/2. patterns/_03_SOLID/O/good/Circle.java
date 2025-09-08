package _03_SOLID.O.good;

import _03_SOLID.O.bad.Shape;

public class Circle extends Shape {

    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
