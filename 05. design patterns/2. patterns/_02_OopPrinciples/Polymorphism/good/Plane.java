package _02_OopPrinciples.Polymorphism.good;

public class Plane extends Vehicle {

    private int numberOfDoors;

    public Plane(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Plane is starting");
    }

    @Override
    public void stop() {
        System.out.println("Plane is stopping");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Plane [brand=" + brand + ", numberOfDoors=" + numberOfDoors + ", model=" + model + ", year=" + year
                + "]";
    }

}
