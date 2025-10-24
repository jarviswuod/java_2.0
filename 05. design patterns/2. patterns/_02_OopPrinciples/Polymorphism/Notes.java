package _02_OopPrinciples.Polymorphism;

/*

    NOTES:
    - Polymorphism;
        - Refers to the ability of an object to take many forms
            - Poly -> many
            - Morph -> forms


    - GOOD CODE EXPLANATION:
        - In this example we have a parent-child relationship between classes. The parent Vehicle class has both fields and methods. The methods start() and stop() are NOT final hence can be overridden by any sub-classes which extends Vehicle
        - The unique thing is we are overriding the start() and stop() methods in a Car, Motorcycle, and Plane subclasses. This is because starting a car involves some different logic to starting both motorcycle or plane

            public class Car extends Vehicle {

                private int numberOfDoors;
                private int numberOfWheels;

                @Override
                public void start() {
                    System.out.println("Car is starting");
                }

                @Override
                public void stop() {
                    System.out.println("Car is stopping");
                }
            }

        - This ability to override the methods allows for polymorphism which allows us to treat all sub classes the same way

            public static void main(String[] args) {
                List<Vehicle> vehiclesGood = new ArrayList<>();

                vehiclesGood.add(new Car("Toyota", "Premio", 2018, 4, 4));
                vehiclesGood.add(new Motorcycle("Ford", "Everest", 2013, 2));

                for (Vehicle vehicle : vehiclesGood) {
                    vehicle.start();
                }
            }

            - We are using the concept of polymorphism here as we are treating all kinds of objects the same as vehicle, we can call all of them and treat them all the same


        - SUMMARY:
            - In this example, we have a list of both instances of Motorcycle and Car. We then iterate through the Vehicle list and perform a general inspection, starting a vehicle
            - Despite the vehicles being of different types, polymorphism allows us to treat them all as instances of Vehicle class even though the implementation of start() and stop() methods are all invoked dynamically at runtime based on the actual type of vehicle.
            - Because the List only contains Vehicle class, all the classes have some common fields and methods we can safely call within the client code without having to worry about each specific vehicle type

            - This shows how polymorphism enables code to be written in a more generic and flexible manner allowing for easy extension and maintenance of new types of Vehicles as they are added to the system

 */

public class Notes {
}
