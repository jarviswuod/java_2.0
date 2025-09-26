package _04_DesignPatterns.Creational.Builder.good;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class CarManualBuilder implements Builder {

    private Manual manual;

    public CarManualBuilder() {
        reset();
    }

    @Override
    public void reset() {
        this.manual = new Manual();
    }

    @Override
    public Builder setCarType(CarType type) {
        manual.setType(type);
        return this;
    }

    @Override
    public Builder setSeats(int seats) {
        manual.setSeats(seats);
        return this;
    }

    @Override
    public Builder setIsConvertible(boolean isConvertible) {
        manual.setConvertible(isConvertible);
        return this;
    }

    @Override
    public Builder setEngine(Engine engine) {
        manual.setEngine(engine);
        return this;
    }

    @Override
    public Builder setDashboard(Dashboard dashboard) {
        manual.setDashboard(dashboard);
        return this;
    }

    @Override
    public Builder setWheels(Wheels wheels) {
        manual.setWheels(wheels);
        return this;
    }

    @Override
    public Builder setGPSNavigator(GpsNavigator gpsNavigator) {
        manual.setGpsNavigator(gpsNavigator);
        return this;
    }

    public Manual getManual() {
        Manual finalManual = manual;
        reset();
        return finalManual;
    }
}
