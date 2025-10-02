package _02_OopPrinciples.Inheritance;

/*

    NOTES:
    - Inheritance;
        - Inheritance involves creating new classes(sub/ derived) based on existing classes (super/ base)
        - Subclasses inherit properties and behaviors from their super classes and can also add new features or override existing ones


    - BAD CODE EXPLANATION:
        - This is a simple class example without inheritance; Both the *Car* and *Bike* can inherit from Vehicle class. Without inheritance we have to copy and paste everything into every single class both the fields and methods to *start* and *stop* the vehicle

            public class Vehicle {
                private String brand;
                private String model;
                private int year;

                public void start() {...}
                public void stop() {...}

                ...
            }

        - ISSUE:
            - We have duplicate code all over the classes and if anything changes in Vehicle class we literally have to change the code in all classes

        - SOLUTION:
            - We solve for all this issue by introducing inheritance, since all the methods and fields are to be same across all classes as they are in Vehicle



    - GOOD CODE EXPLANATION:
        - We inherit by using the *extends* keyword the superclass (Vehicle)

            public class Bike extends Vehicle {...}
            public class Car extends Vehicle {...}

        - We extend our scope or functionalities or scope and adding only subclass fields and method inside the subclass itself
            public class Car extends Vehicle {

                private int numberOfDoors;
                private int numberOfWheels;
                ...
            }

            public class Bike extends Vehicle {
                private int numberOfWheels;
                ...
            }

    - Advantages of inheritance:
        - We don't have to write the commonly used fields and methods for every single Vehicle subclass
        - We can make change(property or method) easily under super class since it's in one place
        - It allows for polymorphism

 */

public class Notes {
}
