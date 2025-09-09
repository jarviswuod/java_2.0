package _03_SOLID.L;

/*

    NOTES:
    - Liskov Substitution Principle: Objects of a superclass should be replaceable with objects of its subclass without affecting the correctness of the program
    - This principle ensures that inheritance hierachies are well designed and sub classes adhere to their super classes contracts.
    - Violation of this principle can lead to unexpected behviour or errors when substituting the objects making the code harder to reason about and maintain

    - BAD CODE EXPLAINED:
        - Over here we have Shape as abstract class where we Rectangle as a concrete class
            public abstract class Shape {

                public abstract double area();
            }

            public class Rectangle extends Shape {
                private double length;
                private double width;
            }

        - We also have a Square class, which inherits a Rectangle class this is based on assumption that a Square is a unique Rectangle with all sides equal to each other
            public class Square extends Rectangle {...}

        - ISSUE:
            - When we follow the Liskov substitution principle, we find that when we replace Rectangle with Square, we tend to have completely different results to what we expect in terms or area;
            
                Rectangle rect = new Rectangle();
                rect.length = 10;
                rect.width = 5;
        
                Square square = new Square();
                square.length = 10;
                square.width = 5;

    - GOOD CODE EXPLAINED:
        - We need to refactor our solution to meet the liskov substitution principle
        - What we will change is we inherit the Shape abstract class directly to Square rather than inheriting Rectangle class the override area() logic
            public class Square extends Shape {
                protected double sideLength;
            }
        - With this everything works corectly
        and as expected;
            public static void main(String[] args) {
                Shape rect = new Rectangle(5, 4);
                Shape square = new Square(5);
            }

        - We have redesigned the square class to directly set the sideLength and now it's correctly modeled as a subclass or Shape and it adhears to liskov princple coz all shapes are substitutable with each other and they calcualte there areas correctly

 */

public class Notes {

}
