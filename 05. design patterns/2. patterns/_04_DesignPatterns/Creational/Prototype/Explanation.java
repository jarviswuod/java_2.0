package _04_DesignPatterns.Creational.Prototype;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have a GUI that allows the user to create new shapes (circles & rectangles) on the screen
        - When the user right-clicks on a shape, an actions menu opens up. The user can then select 'duplicate' to clone the shape


    - SOLUTION 1:
        - Shape interface;
            - It only has draw() method

                    public interface Shape {

                        void draw();
                    }


        - Concrete shapes:
            - Circle class:
                - Implements Shape interface overriding the draw() method
                - We need to give the Circle a property for a 'radius' as all circles need a radius
                - Whenever the user creates a circle on screen we have to give it a default radius length for the user visuals for the newly created Circle

                        public class Circle implements Shape {

                            public int radius = 5;

                            @Override
                            public void draw() {
                                System.out.println("Drawing circle");
                            }
                        }


            - Rectangle class:
                - Implements the Shape interface
                - All rectangles have a width and a height hence the fields are provided with defaults

                    public class Rectangle implements Shape {

                        public int width = 10;
                        public int height = 5;

                        @Override
                        public void draw() {
                            System.out.println("Drawing Rectangle");
                        }
                    }


        - ShapeActions class:
            - This class is going to depend on all the concrete shapes we do have
            - We have a duplicate() method which receives a Shape parameter for it's needed to duplicate any shape
                - We have a conditional statement to help check which shape is passed for duplication
                - We have to cast the shape object into a concrete Shape(The copied shape)
                - Then we have our new shape by creating a new concrete shape(The clone)
                - Then set properties to the new shape we created using values we have from the shape we cloning
                - Then draw the shape to the canvas or wherever the user wants it by calling the draw() method

                        public class ShapeActions {

                            public void duplicate(Shape shape) {
                                if (shape instanceof Circle) {

                                    Circle copiedShape = (Circle) shape; // the copied shape
                                    Circle newShape = new Circle(); // the clone
                                    newShape.radius = copiedShape.radius;
                                    newShape.draw();

                                } else if (shape instanceof Rectangle) {

                                    Rectangle copiedShape = (Rectangle) shape;
                                    Rectangle newShape = new Rectangle();
                                    newShape.width = copiedShape.width;
                                    newShape.height = copiedShape.height;
                                    newShape.draw();

                                } else {

                                    throw new NullPointerException("Invalid shape provided");
                                }
                            }
                        }


        - Main class: Client class;
            - First we create a Circle object
            - Then we render it onto the canvas by calling the draw() method
            - We then simulate the user clicking the circle and dragging to resize the circle by increasing radius to a different value

            - Same concept applies to Rectangle object interms of cloning and whatnot


            - We then simulate the user duplicating shape
                - First we create a ShapeActions object
                - Then we call the shapeActions.duplicate() method passing in Circle and Rectangle objects

                        public class Main {
                            public static void main(String[] args) {

                                Circle circle = new Circle();
                                circle.draw();

                                // User clicks and drags to resize
                                circle.radius = 12;

                                // User adds a new rectangle to GUI
                                Rectangle rectangle = new Rectangle();
                                rectangle.draw();

                                // User clicks and drags rectangle to resize
                                rectangle.width = 20;
                                rectangle.height = 12;

                                // User right-clicking andselecting 'duplicate'
                                ShapeActions shapeActions = new ShapeActions();
                                shapeActions.duplicate(circle);
                                shapeActions.duplicate(rectangle);
                            }
                        }


        - PROBLEMS;
            - We are violating the OCP as we need to modify the ShapeActions class every time we add a new Shape
            - ShapeActions class is coupled to Circle and Rectangle class(concrete classes)
            - ShapeActions has to know about or depend on all kinds of shapes and their specific fields and methods as one can spot circle having a field 'radius' and rectangle having a field 'length' and 'width'. It has to know about the specific implementation details of each of concrete shapes



    - SOLUTION 2: Prototype pattern;
        - We will refactor our code to use the Prototype pattern

        - Shape interface:
            - First we add duplicate() method to the interface so that all shapes are be duplicatable
            - The duplicate() method returns a Shape object

                    public interface Shape {

                        void draw();
                        Shape duplicate();
                    }


        - Circle class:
            - We have to implement the duplicate() method we introduced in Shape interface. Inside of this method we implement the logic for duplicating a Circle class returning the newly cloned Shape
            - Summary:
                - We create a new Circle concrete shape
                - We then set the it's radius to the same radius we have as default radius field
                - We then return the newly created Circle shape

                        public class Circle implements Shape {

                            public int radius = 5;

                            @Override
                            public void draw() {
                                System.out.println("Drawing circle");
                            }

                            @Override
                            public Shape duplicate() {

                                Circle newCircle = new Circle();
                                newCircle.radius = radius;
                                return newCircle;
                            }
                        }


        - Rectangle class:
            - Same process as done by Circle class

                    public class Rectangle implements Shape {

                        public int width = 10;
                        public int height = 5;

                        @Override
                        public void draw() {
                            System.out.println("Drawing Rectangle");
                        }

                        @Override
                        public Shape duplicate() {

                            Rectangle newRectangle = new Rectangle();
                            newRectangle.width = width;
                            newRectangle.height = height;
                            return newRectangle;
                        }
                    }


        - ShapeActions class:
            - The previous very bloated duplicate() method is refactored into something cleaner as all we need is to return shape.duplicate()
            - Since we are returning a shape under the duplicate() method rather than drawing in on the screen, we return the shape and let the client decide what they'll do with the duplicate
            - Optionally, we add log for visuals
                - BEFORE::
                        public void duplicate(Shape shape) {
                            if(shape isntance of Circle) {...}

                            ...
                        }

                - AFTER::
                        public Shape duplicate(Shape shape) {
                            return shape.duplicate();
                        }



                    public class ShapeActions {
                        public Shape duplicate(Shape shape) {

                            System.out.println("Duplicating shape");
                            return shape.duplicate();
                        }
                    }



        - Main class: Client class:
            - Everything seems to be working correctly under the Client side(no changes made)
            - Since duplicate() is now returning a shape we store the shape into a new variable and then decide weather to draw it or not by calling the draw() method on it
                - Essentially giving the client a little more control over what to do with the duplicated shape

                    - BEFORE::
                            shapeACtions.duplicate(circle);
                            shapeACtions.duplicate(rectangle);

                    - AFTER::
                            Shape newRect = shapeACtions.duplicate(rectangle);
                            newRect.draw();
                            Shape newCircle = shapeACtions.duplicate(circle);
                            newCircle.draw();


            - We can now add new shapes e.g Triagle without having to modify the exisiting code in the ShapeActions class

                    public class Main {
                        public static void main(String[] args) {

                            Circle circle = new Circle();
                            circle.draw();

                            circle.radius = 12;

                            Rectangle rectangle = new Rectangle();
                            rectangle.draw();

                            rectangle.width = 20;
                            rectangle.height = 12;

                            System.out.println();

                            ShapeActions shapeActions = new ShapeActions();
                            Shape newcircle = shapeActions.duplicate(circle);
                            newcircle.draw();

                            Shape newrectangle = shapeActions.duplicate(rectangle);
                            newrectangle.draw();
                        }
                    }

 */

public class Explanation {

}
