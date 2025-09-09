package _03_SOLID.O;

/*

    NOTES:
    - Open-closed Principle: Software entities (classes, modules, functions, etc) should be open for extenstion but closed for modifications
    - THis principle promotes the idea that existing code should be able to be extended with new fucntionality without  modifing it's source code.
    - It encourages the user of abstraction and polymorphism to achieve it's goal

    - BAD CODE EXPLAINED:
        - In this example, the Shape class has a calculateArea() method of calculating the area of a shape based on the ShapeType enum
            public class Shape {

                public ShapeType shapeType;
                public double radius;
                public double length;
                public double width;

                public double calculateArea() {
                    switch (shapeType) {
                        case Rectangle:
                            return length * width;

                        case Circle:
                            return Math.PI * Math.pow(radius, 2);

                        default:
                            throw new NullPointerException("Shape is invalid");
                    }
                } 
            }

        - ISSUE:
            - If we add a new ShapeType, say a Triangle and we wanted to support calculating the area of a triangle, we will require modifying the existing Shape class, from adding new proporties and then we have add a switch statement case for it too under the calculateArea() method

            - The class is gonna keep on being modified everytime we add a new Shape, every time we add a new Shape we risk adding bugs to already existing and working code


    - GOOD CODE EXPLAINED:
        - We want to allow for extensions i.e adding a new class to our code base say by extending the Shape instead of having to modify the existing Shape class
            public abstract class Shape {

                public abstract double calculateArea();
            }
        - We can then inherit the abstract class and override the abstract method too, example;

            public class Circle extends Shape {
                private double radius;

                @Override
                public double calculateArea() {
                    return Math.PI * Math.pow(radius, 2);
                }
            }

            public class Rectangle extends Shape {
                private double length;
                private double width;

                @Override
                public double calculateArea() {
                    return length * width;
                }
            }

        - We have refactored the code to having individual Shape classes rather than having one class to manage all the Shapes;
        - With this new solution we can add new Shapes with no pressure, i.e;
        Triangle, Square, etc, without modifying already existing code, all we have to do it to extend the Shape abstract class only and override the calculateArea() method
            public class Triangle extends Shape {
                private double height;
                private double base;

                @Override
                public double calculateArea() {
                    return (1 / 2 * base * height);
                }
            }

 */

public class Notes {

}
