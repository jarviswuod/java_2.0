package _02_OopPrinciples.Inheritance.good;

public class Bike extends Vehicle {

    private int numberOfWheels;

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Bike [brand=" + brand + ", numberOfWheels=" + numberOfWheels + ", model=" + model + ", year=" + year
                + "]";
    }
}