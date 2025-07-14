// 2. Constructor Chaining with super()

public class _31_SuperKeywordExample_2 {
    public static void main(String[] args) {

    }
}

class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(String make, String model) {
        this(make, model, 2023); // Call another constructor in same class
    }
}

class Car extends Vehicle {
    private int doors;
    private String fuelType;

    public Car(String make, String model, int year, int doors, String fuelType) {
        super(make, model, year); // Must be first statement
        this.doors = doors;
        this.fuelType = fuelType;
    }

    public Car(String make, String model, int doors) {
        super(make, model); // Calls parent's two-parameter constructor
        this.doors = doors;
        this.fuelType = "Gasoline";
    }

    @Override
    public String toString() {
        return "Car [doors=" + doors + ", fuelType=" + fuelType + "]";
    }

}