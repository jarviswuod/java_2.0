package _03_SOLID.O;

/*

    NOTES:
    - Open-closed Principle:
        - States that a software entities (classes, modules, functions, etc) should be open for extenstion but closed for modifications
        - This principle promotes the idea that existing code should be able to be extended with new functionality without  modifing it's existing source code
        - It encourages the use of abstraction and polymorphism to achieve it's goal


    - BAD CODE EXPLAINED:
        - Over here we have a Shape class hierarchy that calculates the area of different shapes. At this phase we are violating the Open-closed Princinple because when we add new shapes we will have to modifying already existing code.
        
        - First we have an enum class type that stores our type of shape with only a Circle and Rectangle shapes only
                public enum ShapeType {

                    Circle, Rectangle;
                }

        - Then we have Shape class, it stores the shape type, the radius, length and width, basically different shapes with their corresponding formula for calculating areas
        - calculateArea() method of calculating the area of a shape based on the enum ShapeType

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
            - If we add a new ShapeType, say 'Triangle' and want to calculate it's area, we'll need to modify the existing Shape class. From adding new properties to switching the case under calculateArea() method risking bugs to already existing and working codebase


        - SOLUTION:
            - We need to refactor the code following the Open-closed princple such that we don't have to modify any existing code instead extend already existing class



    - GOOD CODE EXPLAINED:
        - To allow for extensions we make Shape class abstract and make the calcualteArea() too. So any classes that inherit the Shape class have to provide their own implementations of calulateArea method
                public abstract class Shape {

                    public abstract double calculateArea();
                }

        - We then extend the Shape class to have our concrete class with our custom calculateArea() method

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

        - Our Shape class now follows the Single responsibility principle as it only gives a hint of what we need and not calculate area for all shapes we have or want to add

        - With this new solution we can add new Shapes with no pressure, Example;
            - We can add Triangle, Square, etc without modifying the already existing code. All we have to do is to extend the Shape abstract class and override the calculateArea() method

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
