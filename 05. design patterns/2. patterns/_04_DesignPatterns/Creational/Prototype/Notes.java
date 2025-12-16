package _04_DesignPatterns.Creational.Prototype;

/*

    NOTES:
    - Prototype pattern:
        - Is a creational design pattern that allows creation of new objects by copying/ cloning existing ones
        - It focuses on constructing new instances by duplicating existing ones, minimizing the object creation overhead


    - CHALLENGE:
        - Say that we have a GUI that allows the user to create new shapes (circles & rectangles) on the screen
        - When the user right-clicks on a shape, an actions menu opens up. The user can then select 'duplicate' to clone the shape

                  ____________
                  | Shape    |
                  |__________|
                  | draw()   |
                  |__________|
                        ^
                        |
                        |
                        |
                  ____________
                  | Circle   |
                  |__________|-|                ____________________
                  | draw()   | |-|              | ShapeActions     |
                  |__________| | |<-------------|__________________|
                    |__________| |              | duplicate(state) |
                      |__________|              |__________________|


        - We have concrete shapes classes that implement the Shape interface. The ShapeActions class contains the logic for duplicating each shape, and is dependent on all of the shapes that can be duplicated

        - PROBLEM:
            - 



    - SOLUTION 2: PROTOTYPE PATTERN;
        - The logic for duplicating a shape can be moved to each concrete shape class, rather than having it all in ShapeActions.duplicate()
        - We then decouple ShapeActions from all of the concrete shapes, and have it talk to the Shape interface. Flexible, maintable, nice!


                  _______________
                  | Shape       |              ____________________
                  |_____________|              | ShapeActions     |
                  | draw()      |<-------------|__________________|
                  | duplicate() |              | duplicate(state) |
                  |_____________|              |__________________|
                        ^
                        |
                        |
                        |
                  _______________
                  | Circle      |
                  |_____________|-|  
                  | draw()      | |-|
                  | duplicate() | |-|
                  |_____________| | |
                    |_____________| |
                      |_____________|


        - Note:
                - ShapeActions has been sort of lifted up to talk to the single Shape interface rather than talking to several concrete classes

                  ______________              _____________
                  | Prototype  |              | Client    |
                  |____________|<-------------|___________|
                  | clone()    |              | clone()   |
                  |____________|              |___________|
                        ^
                        |
                        |
                        |
              _____________________
              | ConcretePrototype |
              |___________________|-|  
              | clone()           | |-|
              |___________________| | |
                |___________________| |
                  |___________________|

 */

public class Notes {

}
