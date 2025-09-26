package _04_DesignPatterns.Creational.Prototype;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have a GUI that allows the user to create new shapes on the screen, such as circles and rectangles. When the user right-clicks on a shape, an actions menu opens up. The user can then select 'duplicate' to clone the shape


    - SOLUTION 1:
        - Shape interface;
            - It a single method draw()

                    public interface Shape {

                        void draw();
                    }

        - Concrete shapes:
            - Circle class:
                - Implements Shape interface
                - It implements the draw() method by logging for simplicity purposes
                - We need to give the Circle a property for a radius as all propoertie need a radius
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
                - All rectangles have a width and a height hence the fields are needed with defaults

                    public class Rectangle implements Shape {

                        public int width = 10;
                        public int height = 5;

                        @Override
                        public void draw() {
                            System.out.println("Drawing Rectangle");
                        }
                    }

        - ShapeActions class:
            - This class is going to depend on all the concrete shapes we don have
            - We have a duplicate() method with receives a Shape parameter for if we needed to duplicate any shape we'll have to pass it here
                - We have a conditional statement to help check with shape we passed for duplication;
                - We have to cast the shape object into a concrete shape(The copied shape)
                - Then we have our new shape by creating a new concrete shape(the clone)
                - Then we can set properties to the new shape we created using valued we have from the shape we cloning
                - Then we draw the shape to the canvas or wherever the user wants it by calling the draw() method

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
            - Then we call the draw() method i.e we render it onto the canvas

            - We then simulate the user clicking the circle and dragging to resize the circle
                - We then increase he radius to a different value

            - Same concept applies to Rectangle object interms of cloning and whatnot


            - We then simulate the user duplicating shape
                - First we create a ShapeAction object
                - Then we call the shappeActions.duplicate() method passing in Circle and Rectangle objects we've earlier

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
            - We are violating the OCP as we need to modify the ShapeActions class every time we add a new Shape principles
            - ShapeAction class is coupled to Circle and Rectangle class(concrete classes) -  this is evident as we are calling the 'new' keyword
            - ShapeAction has to knoe about or depend on all  kinds of shapes and their specific fields and methods - as one can spot circle having a field 'radius' and rectangle having a field 'length' and 'width'. It has to know about the specific implementation details of each of concrete shapes
            - At this particular time ShapeActions has to know about all the shapes that we support so  what if we wanted to make this app extensible so that other devs can build plugins for this application so that they can define other types of shapes that can be added to the GUI; that can't be achieved with current implementation because at the time of writing code/ at complite time the shape actions class as to know in advance about all the shapetypes which makes it not a flexible solution



    - SOLUTION 2: Prototype pattern;
        - We will refactor our code to use the Prototype pattern

        - Shape interface;
            - First we add duplicated() method to the interface so that all shapes can be duplicated - this methos returns a shape

                    public interface Shape {

                        void draw();
                        Shape duplicate();
                    }


        - Circle class:
            - We have to implement the duplicate() method we introduced in Shape interface. Inside of this method we implement the logic for duplicating a Circle class. NOTE:We dont need reference to the copiedShape object, we can just use the radius field directly
            - We then return this newly created/cloned Shape
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
            - We do the same same process as we did for Circle class

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
            - The previous very bloated duplicate() method is refactored into something cleaner as all we need to do is to return shape.duplicate()
            - Since we are turnning a shape this time under the duplicate() method rather than drawing in on the screen we return the shape and let the client decide what they do with the duplicate
            - Optionaly, we added a log for visuals
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
            - Everything seems to be working corrently under the Client side(no changes made)
            - Because duplicate() is now returning a shape, we modify some code, as we can now store the shape into a new variable and then we cad decide weather to draw it or not by calling the draw() method on it
                - We are giving the client a little more control over what we do with the duplicated shape

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
