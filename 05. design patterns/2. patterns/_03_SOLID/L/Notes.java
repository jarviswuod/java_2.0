package _03_SOLID.L;

/*

    NOTES:
    - Liskov Substitution Principle:
        - It states that objects of a superclass should be replaceable with objects of it's subclass without affecting the correctness of the program
        - Violation of this principle can lead to unexpected behaviour or errors when substituting the objects making the code harder to reason about and maintain


    - BAD CODE EXPLAINED:
        - Shape abstract class:
                public abstract class Shape {

                    public abstract double area();
                }


        - Concrete class:
            - Rectangle class:
                - Consider an example with a Rectangle and Square class both of which inherit from a common Shape class
                - Initially we will violate the Liskov Substitution principle by not following it

                        public class Rectangle extends Shape {

                            private double length;
                            private double width;

                            @Override
                            public double area() {
                                return length * width;
                            }
                        }


            - Square class
                - We also have a Square class. It inherits a Rectangle class, this is based on assumption that a Square is a unique Rectangle with all sides equal to each other

                        public class Square extends Rectangle {

                            @Override
                            public void setLength(double length) {
                                super.setLength(length);
                                super.setWidth(length);
                            }

                            @Override
                            public void setWidth(double width) {
                                super.setWidth(width);
                                super.setLength(width);
                            }

                            @Override
                            public double area() {
                                return getLength() * getWidth();
                            }
                        }


        - Main class:
            - In our main class we create instances of Rectangle and Square and calculate their areas

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

                            System.out.println("Expected area : 5 * 5 = 25");
                            System.out.println("Calculated area : " + square.area());
                        }
                    }


        - ISSUE:
            - From Liskov substitution principle, when we substitute Rectangle for Square the program should just work fine. Instead we have completely different results in comparison to what we expect in terms of area. This should not be the case as it makes it easier for our system to contain bugs


        - SOLUTION:
            - We refactor our program to follow the Liskov Substitution. Basically modifying our Square class such that it no longer extends the Rectangle class and instead extend the Shape class directly too



    - GOOD CODE EXPLAINED:
        - Main && Shape class:
            - Once we inherit Shape abstract class, Square no longer makes sense to have both **legth** and **width**, instead we'll make adjustments to only have sideLength which satisfies the Square requirements for calcualting area. With this everything works correctly and as expected;

                    public class Square extends Shape {

                        protected double sideLength;
                    }

                    public class Main {
                        public static void main(String[] args) {

                            Shape rect = new Rectangle(5, 4);
                            Shape square = new Square(5);
                        }
                    }

        - CONCLUSION:
            - We have redesigned the square class to directly set the sideLength and now it's correctly models as a subclass or Shape and it adhears to Liskov Substitution principle coz all shapes are substitutable with each other and they calculate their respective areas correctly

 */

public class Notes {

}
