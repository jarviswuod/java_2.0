package _04_DesignPatterns.Creational.Builder.good;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class CarBuilder implements Builder {

    private Car car;

    public CarBuilder() {
        reset();
    }

    @Override
    public void reset() {
        this.car = new Car();
    }

    @Override
    public Builder setCarType(CarType type) {
        car.setType(type);
        return this;
    }

    @Override
    public Builder setSeats(int seats) {
        car.setSeats(seats);
        return this;
    }

    @Override
    public Builder setIsConvertible(boolean isConvertible) {
        car.setConvertible(isConvertible);
        return this;
    }

    @Override
    public Builder setEngine(Engine engine) {
        car.setEngine(engine);
        return this;
    }

    @Override
    public Builder setDashboard(Dashboard dashboard) {
        car.setDashboard(dashboard);
        return this;
    }

    @Override
    public Builder setWheels(Wheels wheels) {
        car.setWheels(wheels);
        return this;
    }

    @Override
    public Builder setGPSNavigator(GpsNavigator gpsNavigator) {
        car.setGpsNavigator(gpsNavigator);
        return this;
    }

    public Car getCar() {
        Car finalCar = car;
        reset();
        return finalCar;
    }
}
