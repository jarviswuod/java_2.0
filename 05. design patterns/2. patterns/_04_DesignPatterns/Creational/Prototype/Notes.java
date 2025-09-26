package _04_DesignPatterns.Creational.Prototype;

/*

    NOTES:
    - Prototype pattern:
        - Is a creational design pattern that allows objects to be copied or cloned, providing a mechanism to create a new instances by copying existing objects without explicitly invoking their constructors, and it's used to efficiently produce new instances with identical properties to existing objects


    - CHALLENGE:
        - Say that we have a GUI that allows the user to create new shapes on the screen, such as circles and rectangles. When the user right-clicks on a shape, an actions menu opens up. The user can then select 'duplicate' to clone the shape

                ____________________
                | Shape            |
                |__________________|
                | draw()           |
                |__________________|
                        ^
                        |
                        |
                        |
                _________________
                | Circle        |
                |_______________|-|                ____________________
                | draw()        | |-|              | ShapeActions     |
                |_______________| | |<-------------|__________________|
                  |_______________| |              | duplicate(state) |
                    |_______________|              |__________________|


        - We have concrete shapes classes that implement the Shape interface. The ShapeActions class contains the logic for duplicating each shape, and is dependent on all of the shapes that can be duplicated
        
        - PROBLEM:
            - 



    - SOLUTION 2: PROTOTYPE PATTERN;
        - The logic for duplicating a shape can be moved to each concrete shape class, rather than having it all in ShapeActions.duplicate(). We can then decouple ShapeActions from all of the concrete shapes, and have it talk to the Shape interface. Flexible, maintable, nice!


                ____________________
                | Shape            |              ____________________
                |__________________|              | ShapeActions     |
                | draw()           |<-------------|__________________|
                | duplicate()      |              | duplicate(state) |
                |__________________|              |__________________|
                        ^
                        |
                        |
                        |
                _________________
                | Circle        |
                |_______________|-|  
                | draw()        | |-|
                | duplicate()   | |-|
                |_______________| | |
                  |_______________| |
                    |_______________|


        - Note how ShapeActions has been sort of lifted up to talk to the single Shape interface rather than talking to the many concrete classes

                ___________________              _____________
                | Prototype       |              | Client    |
                |_________________|<-------------|___________|
                | clone()         |              | clone()   |
                |_________________|              |___________|
                        ^
                        |
                        |
                        |
                ______________________
                | ConcretePrototype  |
                |____________________|-|  
                | clone()            | |-|
                |____________________| | |
                  |____________________| |
                    |____________________|

 */

public class Notes {

}
