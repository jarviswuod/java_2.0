package _02_OopPrinciples.Inheritance.good;

public class Car extends Vehicle {

    private int numberOfDoors;
    private int numberOfWheels;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", numberOfDoors=" + numberOfDoors + ", model=" + model + ", numberOfWheels="
                + numberOfWheels + ", year=" + year + "]";
    }

}
