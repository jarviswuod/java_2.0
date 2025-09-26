package _04_DesignPatterns.Creational.Builder.director;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.Sports)
                .setSeats(2)
                .setEngine(new Engine())
                .setDashboard(new Dashboard(true))
                .setWheels(new Wheels(20));
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV)
                .setSeats(5)
                .setEngine(new Engine())
                .setGPSNavigator(new GpsNavigator())
                .setDashboard(new Dashboard(true))
                .setWheels(new Wheels(20));
    }
}
