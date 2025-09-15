package _03_SOLID.I;

/*

    NOTES:
    - Interface Segregation Principle:
        - It states that clients should NOT be FORCED to depend on interfaces they do not use
        - This principle encourages the creation of interfaces that only contain the methods required by the clients that use them
        - It leads to creation of cleaner and more maintainable code


    - BAD CODE EXPLAINED:
        - We are considering an example involving 2D and 3D shapes. Initially we violate the principle
        - First we create an interface called Shape with 2 methods

                public interface IShape {

                    double area();
                    double volume();
                }

        - We create concrete classes implementing the interface Interface

                public class Circle implements IShape {

                    private double radius;

                    ...

                    @Override
                    public double area() {...}

                    @Override
                    public double volume() {...}

                }

                public class Sphere implements IShape {

                    private double radius;

                    ...

                    @Override
                    public double area() {...}

                    @Override
                    public double volume() {...}

                }


        - Logically it makes no sense for Circle to have volume() method, this is because it's 2D shaped, this forces us to throw an exeption as we are also forced to overide it through implementing IShape interface

                public class Circle implements IShape {

                    private double radius;
                    ...

                    @Override
                    public double volume() {
                        throw new NullPointerException("Volume not applicable for 2D shapes");
                    }
                }
        
        - ISSUE:
            - When we run the program an exception thrown from volume() method under Circle. We are forced to override the method as a result of implementing IShape interface, a violation of Interface Segregation Principle as it introduces bug into our program

        
        - SOLUTION:
            - We will refactor our code segregating the IShape interface into IShape2D and IShape3D interfaces and only implementing appropriate interface as required of by concrete classes



    - GOOD CODE EXPLAINED:
        - We break down the IShape interface to IShape2D and IShape3D interfaces and only having the required methods with them

                public interface IShape2D {
                    double area();
                }

                public interface IShape3D extends IShape2D {
                    double volume();
                }

        - We then implement the interfaces to Circle and Sphere classes
                public class Circle implements IShape2D {

                    private double radius;

                   ...

                    @Override
                    public double area() {...}
                }

                public class Sphere implements IShape3D {

                    private double radius;

                    ...

                    @Override
                    public double area() {...}

                    @Override
                    public double volume() {...}
                }

        
        - NOTE:
            - We segregated the IShape interface into smaller fine grained/ more specific interface rather than having a more general one

 */

public class Notes {

}
