package _02_OopPrinciples.Inheritance.good;

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
