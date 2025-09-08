package _02_OOP_Principles.Inheritance.good;

public class Main {
    public static void main(String[] args) {

        // Shared
        Car car = new Car();
        car.start();
        car.stop();

        // Unique
        car.getNumberOfDoors();
        car.getNumberOfWheels();
    }
}
