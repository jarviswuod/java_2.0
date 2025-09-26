package _04_DesignPatterns.Creational.Builder.good;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class Main {
    public static void main(String[] args) {

        CarBuilder carBuilder = new CarBuilder();
        carBuilder.setCarType(CarType.Sports).setSeats(2).setEngine(new Engine()).setDashboard(new Dashboard(true))
                .setWheels(new Wheels(20));
        Car sportsCar = carBuilder.getCar();
        sportsCar.setFuel(100);

        CarManualBuilder sportsCarManualBuilder = new CarManualBuilder();
        sportsCarManualBuilder.setCarType(CarType.Sports).setSeats(2).setEngine(new Engine())
                .setDashboard(new Dashboard(true))
                .setWheels(new Wheels(20));
        Manual sportsManualBuilder = sportsCarManualBuilder.getManual();
        System.out.println(sportsManualBuilder);

    }
}
