package _03_SOLID.D.good;

public class Car {

    private IEngine engine;

    public Car(IEngine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Car started");
    }
}
