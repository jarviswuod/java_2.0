package _02_OopPrinciples.Polymorphism.good;

public class Car extends Vehicle {

    private int numberOfDoors;
    private int numberOfWheels;

    public Car(String brand, String model, int year, int numberOfDoors, int numberOfWheels) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void start() {
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }

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
