package _03_SOLID.D;

/*

    NOTES:
    - Dependecy Inversion Principle:
        - It states that high-level modules should not depend on low-level modules. Both should depend on abstractions
        - It's a strategy of depending upon interfaces/ abstract classes rather than upon concrete classes
        - It promotes decoupling between modules
        - It also promotes the use of interfaces/ abstracts to define dependency allowing for more flexible and testable code


    - BAD CODE EXPLAINED:
        - Engine class:
            - We create an Engine class which only has one method, start()

                    public class Engine {

                        public void start() {
                            System.out.println("Engine started");
                        }
                    }


        - Car class:
            - We then create a Car class which is a composition of other classes(Engine, Seats, Chassis, Doors, wheels) inclusive of our Engine class
                    public class Car {

                        private Engine engine;

                        public Car() {
                            this.engine = new Engine();
                        }

                        public void startCar() {
                            engine.start();
                            System.out.println("Car started");
                        }
                    }

            - NOTE:
                - The Car class has direct dependency on the concrete Engine class. We say this because on the Car constructor we have created an Engine instance


        - ISSUE:
            - Once we create a Car object, we have NO way to changing the type of Engine
                    public class Main {
                        public static void main(String[] args) {

                            Car car = new Car();
                            car.startCar();
                        }
                    }

            - We have a Car class which has a dependency on concrete Engine class
            - The car class directly creates an instance of the Engine class. This leads to a tight coupling between Car and Engine. This means if something under the Engine class changes, it my affect the Car class changes. This is violation of Dependency Injection


        - SOLUTION:
            - To solve the issue we'll introduce an interface or abstract class between the Engine and Car class
            - This allows Car to depend on abstraction instead of concrete Engine class implementation



    - GOOD CODE EXPLAINED:
        - Engine interface:
            - We create an interface called Engine which has a start() method as all engines should

                    public interface Engine {

                        void start();
                    }


        - Concrete classes:
            - ElectricEngine class:
                - We then implement the Engine interface to Engine class with a custom start() method
                        public class ElectricEngine implements Engine {

                            @Override
                            public void start() {
                                System.out.println("ElectricEngine started");
                            }
                        }


        - Car class:
            - We currently have Car class depending on ElectricEngine class rather than an interface, we need to change that
                - OLD ::
                    public class Car {

                        private Engine engine;

                        public Car() {
                            this.engine = new Engine();
                        }

                        public void startCar() {
                            engine.start();
                            System.out.println("Car started");
                        }
                    }


                - NEW ::
                    public class Car {

                        private Engine engine;

                        public Car(Engine engine) {
                            this.engine = engine;
                        }

                        public void startCar() {
                            engine.start();
                            System.out.println("Car started");
                        }
                    }


        - Conclusion:
            - The advantage of this method is that it provides as with the flexibility to pass any type of Engine class we want the Car to be built with at runtime
                - This is called dependecy Injection, as we inject the dependency into the class

                    public class Main {
                        public static void main(String[] args) {

                            Car car = new Car(new ElectricEngine());
                            Car car = new Car(new DieselEngine());

                            car.startCar();
                        }
                    }


        - Advantages of Dependecy Injection;
            1. It promotes loose coupling between components by removing direct dependencies so that components rely on abstractions rather than concrete implementations, this makes them more independent and easy to maintain
            2. It simplifies unit testing by allowing components to be easily replaced with mock or stub implemetation during testing this enables isolated testing of individual components without relying on dependecies
            3. It impoves flexiblity because we could swap out dependecies at runtime

 */

public class Notes {

}
