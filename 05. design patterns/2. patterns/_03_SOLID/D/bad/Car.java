package _03_SOLID.D.bad;

public class Car {

    private Engine engine;

    public Car() {
        this.engine = new Engine();
    }

    public void startCar() {
        engine.start();
        System.out.println("Car started");
    }
}
