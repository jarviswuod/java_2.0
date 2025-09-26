package _04_DesignPatterns.Creational.Builder;

/*

    - CODE EXPLANATION:


    - CHALLENGE:
        - Say we have a class called Car and we also have a manual class that's used to create Car manuals for certain cars



    - SOLUTION 1:
        - Car & Manual classes:
            - We use this class to create Car objects and also have a Manual class to create Car manuals for certain cars
            - Car has a set of fields while Manual also has a set of the same fields too
            - A car or manual is composed of several fields CarType, Engine, Dashboard, Wheels, GPSNavigator

        - Components:
            - CarType enum:
                - Car can be either Sports, SUV, Saloon;

                    public enum CarType {

                        Sports, SUV, Saloon;
                    }


            - Dashboard class:
                - This class can be configured to having a revCounter or not

                    public class Dashboard {

                        private boolean hasRevCounter = false;

                        public Dashboard(boolean hasRevCounter) {
                            this.hasRevCounter = hasRevCounter;
                        }
                    }


            - Engine class:
                - This class provides methods and fields for speed, model, etc

                    public class Engine {

                        // Configuration, e.g speed, model, etc.
                    }


            - GpsNavigator class:
                - Kept simple at this point

                    public class GpsNavigator {

                        // Configurations...
                    }


            - Wheels class:
                - With a field to represent diameter of wheels in inches as sort of example

                    public class Wheels {

                        private double diameterInInches;

                        public Wheels(double diameterInInches) {
                            this.diameterInInches = diameterInInches;
                        }

                        public double getDiameterInInches() {
                            return diameterInInches;
                        }
                    }



        - Car and Manual classes:
            - We notice in Car and in Mauals they share a lot of common fields and also in Car we have a field which is specific to Car class 'fuel' i.e not relevant to Manual class,,, it represents the amout of fuel in the car. In manual we also have a toString() used to print the text or create a manual from the fields or information that has been set on the object

                    public class Car {

                        public CarType type;
                        public int seats;
                        public boolean isConvertible;
                        public Engine engine;
                        public Dashboard dashboard;
                        public Wheels wheels;
                        public GpsNavigator gpsNavigator;

                        // Fields specific to this class:
                        private double fuel;

                        public Car(CarType type, int seats, boolean isConvertible, Engine engine, Dashboard dashboard, Wheels wheels,
                                GpsNavigator gpsNavigator) {
                        
                            ...
                        }

                        public double getFuel() {
                            return fuel;
                        }

                        public void setFuel(double fuel) {
                            this.fuel = fuel;
                        }
                    }



        - Main class: Client class;
            - First we create a sportsCar an object of Car with all the necessary parameters filled
            - Then we can specify the amount of fuel in the sportsCar
            - We then create our another Car instance named suvCar

            - NOTE::
                - At this point you can notice that we have to provide lot's of config options when creating Car instances

            - We also create a sportsCarManual which is an instance of Manual class - it also has as much configs provided as the Car objects
            - We also do the same for suvCarManual too

            - NOTE::
                - When you create a manual instance you notice we provide the exact same parameters as we do when creating a Car instance but keep in mind these are 2 different objects that are not really related in any way, they dont share any common interface

            - If you test this, it all works great

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



    - SOLUTION 2: BUILDER PATTERN;
        - Car class:
            - First things first, we need to recreate our Car class, previously we passed all of the values we needed to the constructor, we won;t do that now, what we'll do instead is provide normal fields then adding normal setters and getter methods to them

                    public class Car {

                        private CarType type;
                        private int seats;
                        private boolean isConvertible;
                        private Engine engine;
                        private Dashboard dashboard;
                        private Wheels wheels;
                        private GpsNavigator gpsNavigator;

                        // Fields specific to this class:
                        private double fuel;

                        public CarType getType() {
                            return type;
                        }

                        public void setType(CarType type) {
                            this.type = type;
                        }

                        ...

                    }



        - Manual class:
            - We create manuals in the same way, by moving away from passing constructors to instead using properties to set the fields within the Builder classes that we are going to create

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

                        ...
                    }



        - Builder interface:
            - This will contain all of the possible steps for building a Car or a Manual
            - Over here we have methods;
                -  First we have the reset() method and this essentially in our concrete builders will reset the kind of object field e.g if we have a Car builder, the car builder has a field of car and it builds up that car with method that provide inside the Builder interface; the reset() method will basically reset that Car object to a brand new object -  it's a common method included in teh BUilder pattern
                - Next we create a setCarType() taking CarType type it returns a Builder this will allow us to chain method onto each other when we creating a Car or Manual
                - Same concept applies to all other methods as from IsConvertible(), setEngine(), setWheels, setDashboard() and setGpsNavigator(); basically all the methods needed to build a Car


                    public interface Builder {

                        void reset();

                        Builder setCarType(CarType type);

                        Builder setSeats(int seats);

                        Builder setIsConvertible(boolean isConvertible);

                        Builder setEngine(Engine engine);

                        Builder setDashboard(Dashboard dashboard);

                        Builder setWheels(Wheels wheels);

                        Builder setGPSNavigator(GpsNavigator gpsNavigator);
                    }



        - Concrete Builder class:
            - CarBuilder class:
                - It implements the Builder interface which forces us to implement all the methods we defined above
                - The Car builder needs to store a field of a type Car and then in the constructor we could call the reset() method - essentially whenever we create a new Car builder object we are going to set this to a new blank car object/a fresh car object;
                    - NOTE::: We dont pass anything inside the constructor method we created

                - Inside of the reset() method we are setting the Car field into a new Car
                - Let's create one method for demo; for instance SetCarType() it takes in a Car object and sets this sets our builder class car instance to the car object we passed and then we need to return the Builder at the end of the method hence we return 'this' because 'this' is a CarBuilder which is a Builder -  it's implementing a Builder interface
                    public Builder setCarType(CarType type) {
                        this.SetCarType(type);
                    }

                - Finally we have a getCar() method which returns a Car at the end. You can note that we store car in a car in a variable and then we reset() our car as a new car object once we get the car and then returning the car we stored in field inside this very method.
                    - This is not very necessary in the builder method but it's commonly done - kinda an optional step whether you reset the object or leave it as it isand maybe leave the client to call it if they want to

                    public class CarBuilder implements Builder {

                        private Car car;

                        public CarBuilder() {
                            reset();
                        }

                        @Override
                        public void reset() {
                            this.car = new Car();
                        }

                        @Override
                        public Builder setCarType(CarType type) {
                            car.setType(type);
                            return this;
                        }

                        ...


                        public Car getCar() {
                            Car finalCar = car;
                            reset();
                            return finalCar;
                        }
                    }



            - CarManualBuilder class:
                - We implement the Builder interface and then do the exact same thing we have done with our CarBuilder class
                - It's exactly the same as what we have in our CarBuilder because it's implementing the Builder interface the only difference is that we are storing a reference to a Manual rather than a Car

                    public class CarManualBuilder implements Builder {

                        private Manual manual;

                        public CarManualBuilder() {
                            reset();
                        }

                        @Override
                        public void reset() {
                            this.manual = new Manual();
                        }

                        @Override
                        public Builder setCarType(CarType type) {
                            manual.setType(type);
                            return this;
                        }

                        ...

                        public Manual getManual() {
                            Manual finalManual = manual;
                            reset();
                            return finalManual;
                        }
                    }



        - Main class: Client class;
            - First we create a CarBuilder instance
            - Next is actually building a car using the carBuilder instance we have while chaining the methods
            - We finally create a Car instance by calling the getCar() method on carBuilder instance we just methods to
            - We then set fuel on the car which works flawlessly

            - We can now create our ManualBuilder next for a sportsCar
                - Here we are creating a CarManualBuilder instance
                - We then chain the methods needed to create a manual
                - Finally we get the manual instance by calling .getManual() method on manualBuilder instance we just creaetd
                - We then log the manual to the screen which works flawlessly

                    public class Main {
                        public static void main(String[] args) {

                            CarBuilder carBuilder = new CarBuilder();
                            carBuilder.setCarType(CarType.Sports)
                                    .setSeats(2)
                                    .setEngine(new Engine())
                                    .setDashboard(new Dashboard(true))
                                    .setWheels(new Wheels(20));
                            Car sportsCar = carBuilder.getCar();
                            sportsCar.setFuel(100);

                            CarManualBuilder sportsCarManualBuilder = new CarManualBuilder();
                            sportsCarManualBuilder.setCarType(CarType.Sports)
                                    .setSeats(2)
                                    .setEngine(new Engine())
                                    .setDashboard(new Dashboard(true))
                                    .setWheels(new Wheels(20));
                            Manual sportsManualBuilder = sportsCarManualBuilder.getManual();
                            System.out.println(sportsManualBuilder);

                        }
                    }



        - OBSERVATION::
            - This is a nicer solution as we now only need to specify the car or manual propoerties example, we don't need to specify if the car isConvertible as we did beforehand when we had to provide all the data via constructor of a Car or Manual when we create an instance
            - We can now also conveniently chain methods this is because we are actually returning the current object from each method call
            - THE PROBLEM with solution over here is that we still have to specify a large number of fields when creating cars and manuals and also because car builders and car manuals builder both implement the same Builder interface we can now use polymorphism to create Cars and Manuals as producing Manuals for a specific car e.g sportsCar requires the exact  same steps i.e if a car has a GPS that has to be documented in the manual.
            - We can implement this using the director class



    - SOLUTION 3: Director class with Builder pattern;
        - Director class:
            - We have 2 methods inside this class one constructing a sports car the other for constructing an SUV - we have to pass the Builder interface inside the methods. We then call the builder instance with all the build steps inside the method for both methods calling the required methods in both cases
            - NOTE::: We don't actually return the final product in either methods for either a Car or a Manual for each method within the director class and this is because each product is returned from it's respective concrete builder - reason for this is Car and Manual objets don't share a common interface

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



        - Main Class: Client class;
            - First is creating a CarBuilder instance
            - Then creating our Director instance
            - Then let's create a sports car - this is done by calling the constructorSportsCar and passing the carBuilder instance we created above
            - We finally get the Car by calling the carBuilder.getCar() method
            - We then call sportsCar.setFuel()

            - We also create an SUV by calling director.constructSuv() passing in carBuilder object/instance
            - We then create the car by calling carBuilder.getCar() and set fuel to the SUV

            - We can finally produce some manuals for the cars we created - same concept applies as when we are creating a car only that we pass in a manualBuilder object/instance to the director.constructSportsCar() or constructSuv()

                    public class Main {
                        public static void main(String[] args) {

                            CarBuilder carBuilder = new CarBuilder();
                            Director director = new Director();

                            director.constructSportsCar(carBuilder);
                            Car sportsCar = carBuilder.getCar();
                            sportsCar.setFuel(100);

                            director.constructSUV(carBuilder);
                            Car suvCar = carBuilder.getCar();
                            suvCar.setFuel(40);

                            CarManualBuilder manualBuilder = new CarManualBuilder();
                            director.constructSportsCar(manualBuilder);
                            Manual sportsCarManual = manualBuilder.getManual();
                            System.out.println(sportsCarManual);

                            director.constructSUV(manualBuilder);
                            Manual suvCarManual = manualBuilder.getManual();
                            System.out.println(suvCarManual);

                        }
                    }



        - OBSERVATION:
            - When we run the program, everything works super great
            - We finally used the builder pattern to resuse the same object construction code or build steps to build different kinds of products i.e cars and their corresponding manuals

            - NOTE::
                - Other creational patterns focus on producing objects that share a common interface but the Builder pattern defers in that it can construct objects of different types providing that they share a common set of build steps

 */

public class Explanation {

}
