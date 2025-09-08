package _02_OopPrinciples.Inheritance.bad;

public class Bike {
    private String brand;
    private String model;
    private int year;

    private int numberOfWheels;

    public void start() {
        System.out.println("Bike is starting");
    }

    public void stop() {
        System.out.println("Bike is stopping");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Bike [brand=" + brand + ", model=" + model + ", year=" + year
                + ", numberOfWheels=" + numberOfWheels + "]";
    }
}