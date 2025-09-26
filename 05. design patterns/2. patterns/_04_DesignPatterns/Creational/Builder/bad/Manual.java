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
        return "Manual [type=" + type + ", seats=" + seats + ", isConvertible=" + isConvertible + ", engine=" + engine
                + ", dashboard=" + dashboard + ", wheels=" + wheels + ", gpsNavigator=" + gpsNavigator + "]";
    }
}
