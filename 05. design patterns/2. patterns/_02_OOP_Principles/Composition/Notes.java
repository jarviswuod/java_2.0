package _02_OOP_Principles.Composition;

/*

    NOTES:
    - Composition involves creating complex objects by combining simpler objects or componets. 
    - In composition, objects are assembled together to form large strctures, with each component object maintaining it's own state and behavious.
    - Composition is often described in terms of a 'has-a' relationship

    - Compositing Example explanation:
        - Here we loads of objects that make up a Car,
            - Example;
                - A car has Chassis with support() method
                - A car has Wheels with rotate() method
                - A car has Engine with start() method
                - A car has Seats with sitting() method

            - This are all parts that a Car is made of, it uses composition to assemble all the parts needed

        - The Car class contains instances of all the component classes and delegates tasks to them rather than doing all that work by itself
                public void startCar() {
                    engine.start();
                    wheels.rotate();
                    chassis.support();
                    seats.sit();
                    System.out.println("Car started");
                }

        - To start a Car is super easy; you just create an instance of Car and call the start() method
                public static void main(String[] args) {
                        Car car = new Car();
                        car.startCar();
                }

*/

public class Notes {
}
