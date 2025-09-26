package _04_DesignPatterns.Creational.Builder.bad;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class Manual {

    public CarType type;
    public int seats;
    public boolean isConvertible;
    public Engine engine;
    public Dashboard dashboard;
    public Wheels wheels;
    public GpsNavigator gpsNavigator;

    public Manual(CarType type, int seats, boolean isConvertible, Engine engine, Dashboard dashboard, Wheels wheels,
            GpsNavigator gpsNavigator) {
        this.type = type;
        this.seats = seats;
        this.isConvertible = isConvertible;
        this.engine = engine;
        this.dashboard = dashboard;
        this.wheels = wheels;
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
