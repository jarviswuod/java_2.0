package _04_DesignPatterns.Creational.Builder.director;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class Manual {

    private CarType type;
    private int seats;
    private boolean isConvertible;
    private Engine engine;
    private Dashboard dashboard;
    private Wheels wheels;
    private GpsNavigator gpsNavigator;

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean isConvertible) {
        this.isConvertible = isConvertible;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public GpsNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public void setGpsNavigator(GpsNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    @Override
    public String toString() {
        return "Manual [type=" + type + ", seats=" + seats + ", isConvertible=" + isConvertible + ", engine=" + engine
                + ", dashboard=" + dashboard + ", wheels=" + wheels + ", gpsNavigator=" + gpsNavigator + "]";
    }
}
