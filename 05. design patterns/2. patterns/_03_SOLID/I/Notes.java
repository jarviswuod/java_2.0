package _03_SOLID.I;

/*

    NOTES:
    - Interface Segregation Principle:
        - It states that clients should NOT be FORCED to depend on interfaces they do not use
        - This principle encourages the creation of interfaces that only contain the methods required by the clients that use them
        - It leads to creation of cleaner and more maintainable code


    - BAD CODE EXPLAINED:
        - We are considering an example involving 2D and 3D shapes. Initially we violate the principle
        - Shape interface:
            - First we create an interface called Shape with 2 methods

                    public interface Shape {

                        double area();
                        double volume();
                    }


        - Concrete class:
            - Circle and Sphere classes:
                - We create concrete classes implementing the interface Interface

                    public class Circle implements Shape {

                        private double radius;

                        ...

                        @Override
                        public double area() {...}

                        @Override
                        public double volume() {...}

                    }


                    public class Sphere implements Shape {

                        private double radius;

                        ...

                        @Override
                        public double area() {...}

                        @Override
                        public double volume() {...}

                    }


        - OBSERVATION:
            - Logically, it makes no sense for Circle to have volume() method, this is because it's 2D shaped, this forces us to throw an exeption as we are also forced to override it through implementing Shape interface

                    public class Circle implements Shape {

                        private double radius;
                        ...

                        @Override
                        public double volume() {
                            throw new UnsupportedOperationException("Volume not applicable for 2D shapes");
                        }
                    }


        - ISSUE:
            - When we run the program an exception thrown from volume() method under Circle. We are forced to override the method as a result of implementing Shape interface, a violation of Interface Segregation Principle as it introduces bug into our program

        
        - SOLUTION:
            - We will refactor our code segregating the Shape interface into Shape2D and Shape3D interfaces and only implementing appropriate interface as required of by concrete classes



    - GOOD CODE EXPLAINED:
        - Shape2D interface:
        - Shape3D interface:
            - We break down the Shape interface to Shape2D and Shape3D interfaces and only having the required methods with them

                    public interface Shape2D {
                        double area();
                    }

                    public interface Shape3D extends Shape2D {
                        double volume();
                    }


        - Concrete classes:
            - Circle and Sphere classes:
                - We then implement the interfaces to Circle and Sphere classes
                        public class Circle implements Shape2D {

                            private double radius;

                            ...

                            @Override
                            public double area() {...}
                        }


                        public class Sphere implements Shape3D {

                            private double radius;

                            ...

                            @Override
                            public double area() {...}

                            @Override
                            public double volume() {...}
                        }


        - NOTE:
            - We segregated the Shape interface into smaller fine grained/ more specific interface rather than having a more general one

 */

public class Notes {

}
