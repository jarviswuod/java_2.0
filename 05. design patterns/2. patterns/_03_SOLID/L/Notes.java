package _03_SOLID.L;

/*

    NOTES:
    - Liskov Substitution Principle:
        - It states that objects of a superclass should be replaceable with objects of it's subclass without affecting the correctness of the program
        - Violation of this principle can lead to unexpected behaviour or errors when substituting the objects making the code harder to reason about and maintain


    - BAD CODE EXPLAINED:
        - Consider an example with a Rectangle class and Square class which inherit from a common Shape class, initially we will violate the Liskov principle by not following it
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
            - From Liskov substitution principle, when we substitute Rectangle for Square the program should just work fine, instead we have completely different results in comparison to what we expect in terms or area. This should not be the case as it makes it easier for our system to contain bugs

                    public class Main {
                        public static void main(String[] args) {

                            Rectangle rect = new Rectangle();
                            rect.setLength(10);
                            rect.setWidth(5);

                            System.out.println("Expected area : 10 * 5 = 50");
                            System.out.println("Calculated area : " + rect.area());

                            Square square = new Square();
                            square.setLength(10);
                            square.setWidth(5);

                            System.out.println("Expected area : 10 * 5 = 50");
                            System.out.println("Calculated area : " + square.area());
                        }
                    }


        - SOLUTION:
            - We refactor our program to follow the Liskov Substitution. We'll basically modify our Square class such that it no longer extends the Rectangle class instead extends the Shape class directly



    - GOOD CODE EXPLAINED:
        - Once we inherit Shape abstract class, Square no longer makes sense to have both **legth** and **width**, instead we'll make adjustments to only have sideLength which satisfies the Square requirements for calcualting area. With this everything works corectly and as expected;

                public class Square extends Shape {

                    protected double sideLength;
                }

                public class Main {
                    public static void main(String[] args) {

                        Shape rect = new Rectangle(5, 4);
                        Shape square = new Square(5);
                    }
                }

        - We have redesigned the square class to directly set the sideLength and now it's correctly models as a subclass or Shape and it adhears to liskov princple coz all shapes are substitutable with each other and they calculate their areas correctly

 */

public class Notes {

}
