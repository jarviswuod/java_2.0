package _02_OopPrinciples.Polymorphism.good;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehiclesGood = new ArrayList<>();

        vehiclesGood.add(new Car("Toyota", "Premio", 2018, 4, 4));
        vehiclesGood.add(new Motorcycle("Ford", "Everest", 2013, 2));

        for (Vehicle vehicle : vehiclesGood) {
            vehicle.start();
        }

        System.out.println();

        List<Object> vehiclesBad = new ArrayList<>();

        vehiclesBad.add(new Car("Toyota", "Premio", 2018, 4, 4));
        vehiclesBad.add(new Motorcycle("Ford", "Everest", 2013, 2));

        for (Object vehicle : vehiclesBad) {
            ((Vehicle) vehicle).start();
        }
    }
}
