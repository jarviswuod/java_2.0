package _02_OopPrinciples.Inheritance.good;

public class Main {
    public static void main(String[] args) {

        // Shared
        Car car = new Car();
        car.start();
        car.stop();

        // Unique
        System.out.println(car.getNumberOfDoors());
        System.out.println(car.getNumberOfWheels());
    }
}
