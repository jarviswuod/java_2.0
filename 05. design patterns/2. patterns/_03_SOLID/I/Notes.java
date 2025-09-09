package _03_SOLID.I;

/*

    NOTES:
    - Interface Segregation Principle: Clients should not be forced to depend on interfaces they do not use
    - This principle encourages the creation of interfaces that only contain the methods required by the clients that use them.
    - It leads to creation oc cleaner and more maintainable code

    - BAD CODE EXPLAINED:
        - We create an interface having 2 properties
            public interface IShape {
                double area();
                double volume();
            }

        - We implement the interface to Circle and Sphere

            public class Circle implements IShape {...}
            public class Sphere implements IShape {...}

        - We notice an issue with Circle class since it has no volume, the volume() method throws an exception
            @Override
            public double volume() {
                throw new NullPointerException("Volume not applicable for 2D shapes");
            }
        
        - ISSUE:
            - We are basically forcing the Circle class to implement the volume methods, even though we really dont need it as we don't have a 3D shape to measure it's volume
            - This is a violation of Interface Segregation Principle and is introducing bug into our program


    - GOOD CODE EXPLAINED:
        - We solve for the issue by segregating our interface more into IShape2D and IShape3D with 2D only having area and 3D having volume
            public interface IShape2D {
                double area();
            }

            public interface IShape3D extends IShape2D {
                double volume();
            }
        - We then implement the interfaces to Cicle and Sphere classes

 */

public class Notes {

}
