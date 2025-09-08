package _02_OOP_Principles.Composition.good;

public class Car {

    private Engine engine = new Engine();
    private Wheels wheels = new Wheels();
    private Chassis chassis = new Chassis();
    private Seats seats = new Seats();

    public void startCar() {
        engine.start();
        wheels.rotate();
        chassis.support();
        seats.sit();
        System.out.println("Car started");
    }

}
