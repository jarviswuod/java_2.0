package _04_DesignPatterns.Creational.Builder.bad;

import _04_DesignPatterns.Creational.Builder.Components.*;

public class Main {
    public static void main(String[] args) {

        Car sportsCar = new Car(CarType.Sports, 2, false, new Engine(), new Dashboard(true), new Wheels(20),
                new GpsNavigator());
        sportsCar.setFuel(100);

        Car suvCar = new Car(CarType.SUV, 5, false, new Engine(), new Dashboard(true), new Wheels(19),
                new GpsNavigator());
        suvCar.setFuel(40);

        Manual sportsCarManual = new Manual(CarType.Sports, 2, false, new Engine(), new Dashboard(true), new Wheels(20),
                new GpsNavigator());
        System.out.println(sportsCarManual);

        Manual suvCarManual = new Manual(CarType.SUV, 2, false, new Engine(), new Dashboard(true), new Wheels(20),
                new GpsNavigator());
        System.out.println(suvCarManual);
    }
}
