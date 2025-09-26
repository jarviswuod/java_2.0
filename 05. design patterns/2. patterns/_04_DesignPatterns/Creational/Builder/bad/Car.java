package _04_DesignPatterns.Creational.Builder.bad;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class Car {

    public CarType type;
    public int seats;
    public boolean isConvertible;
    public Engine engine;
    public Dashboard dashboard;
    public Wheels wheels;
    public GpsNavigator gpsNavigator;

    // Fields specific to this class:
    private double fuel;

    public Car(CarType type, int seats, boolean isConvertible, Engine engine, Dashboard dashboard, Wheels wheels,
            GpsNavigator gpsNavigator) {
        this.type = type;
        this.seats = seats;
        this.isConvertible = isConvertible;
        this.engine = engine;
        this.dashboard = dashboard;
        this.wheels = wheels;
        this.gpsNavigator = gpsNavigator;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}
