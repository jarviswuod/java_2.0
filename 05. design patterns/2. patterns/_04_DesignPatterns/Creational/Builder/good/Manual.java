package _04_DesignPatterns.Creational.Builder.good;

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
        String text = "";

        text += "Car type: " + this.type + "\n";
        text += "Seats: " + this.seats + "\n";
        text += "Wheels: diameter in inches + " + this.wheels.getDiameterInInches() + "\n";
        text += "Engine: info on engine...  " + this.type + "\n";
        text += "GPS Navigator: ";
        if (this.gpsNavigator != null) {
            text += "Inf on gps... \n";
        } else {
            text += "N/A \n";
        }

        return text;
    }
}
