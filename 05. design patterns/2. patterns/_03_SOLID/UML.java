package _03_SOLID;

/*

    NOTES:
    - Unified Modeling Language: UML
        - UML is a language used to model our relationships between classes

    - Representing classes using UML

                 __________________            public class Dog() {
                |  Dog             |                private String name;
                |__________________|                
                |  - name:String   |                public void bark() {
                |__________________|                    System.out.println("Woof Woof");
                |  + bark():       |                }
                |__________________|            }   

        - "-" means private access modifiers
        - "+" means public access modifiers

        - Value after ":" is the type. If there is not colon after the method, then void is the return type


    - Relationship representation in UML:

        1. Inheritance Relationship:
            - Represented by an arrow
            - Example:
                - The Dog inherits from the Animal class

                ____________________
                |    Animal        |
                |__________________|            
                |                  |
                |__________________|            public class Animal() {...}
                         ^
                         |
                _________|__________            public class Dog extends Animal() {
                |     Dog          |                private String name;
                |__________________|                
                |  - name:String   |                public void bark() {
                |__________________|                    System.out.println("Woof Woof");
                |  + bark():       |                }
                |__________________|            }   


        2. Composition Relationship:
            - Represented with a filled diamond
            - Example;
                - The Dog is composed of the Size class

                ____________________
                |    Size          |
                |__________________|
                |                  |
                |__________________|            public class Size() {...}
                         ^
                         v
                         |
                         |
                         v
                ____________________            public class Dog extends Animal() {
                |     Dog          |                private Size size;
                |__________________|            }
                |  - size: size    |
                |__________________|
                |  + bark():       |
                |__________________|


        3. Association Relationship:
            - Represented by an arrow
            - Example;
                - A person has a Car (NOTE: A person is NOT composed of a Car)
            ____________________                ____________________
            |    Person        |                |    Car           |
            |__________________|--------------->|__________________|
            |  - car: car      |                |__________________|
            |__________________|                |__________________|


            - Difference between Association and Composition Relationship:
                - Association:
                    - When a child object can still exist without it's other object class
                        - Example:
                            - A person has a Car, NOT composed of a Car. This means a person holds a reference to Car so he/she can interact with it, but a Person CAN exist without a Car


                - Composition:
                    - When a child object wouldn't be able to exist without it's parent object
                        - Example:
                            - A Hotel is composed of it's rooms, and HotelBathroom cannot exist without Hotel(destory the hotel you destroy the HotelBathroom - it can't exist by itself)
                            - If a Customer is destroyed their ShippingCart and Orders are lost too. Therefore Customer is composed of ShoppingCart and Orders
                            - If Orders are lost, OrderDetails and ShippingInfo are lost. The orders are composed of shipingInfor and OrderDetails


        4. Dependency Relationship:
            - Represented by a dashed arrow
            - Example;
                - Dog has a dependecy with documents
            ____________________                ____________________
            |    Dog           |                |   Document       |
            |__________________|--------------->|__________________|
            |                  |
            |__________________|

            public class Dog {
                public void render(Document document) {...}
            }

            - Document is not a field in this class, but is used somewhere in the class, in this case it's a pameter, but it could also be a local varaible defined in the render() method. Or somewhere in the Dog class, we have a reference/ dependncy to the Document class

 */

public class UML {

}
