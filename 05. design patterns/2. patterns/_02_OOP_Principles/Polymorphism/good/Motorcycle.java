package _02_OOP_Principles.Polymorphism.good;

public class Motorcycle extends Vehicle {

    private int numberOfWheels;

    public Motorcycle(String brand, String model, int year, int numberOfWheels) {
        super(brand, model, year);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping");
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Motorcycle [brand=" + brand + ", numberOfWheels=" + numberOfWheels + ", model=" + model + ", year="
                + year
                + "]";
    }

}