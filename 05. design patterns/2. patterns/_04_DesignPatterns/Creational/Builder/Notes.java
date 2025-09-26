package _04_DesignPatterns.Creational.Builder;

/*

    NOTES:
    - The Builder Pattern:
        - Is a design pattern used to construct complex objects step by step, providing clarity and flexilibity in the creation process



    - CHALLENGE:
        - Say we have a class called Car ad we also have a manual class that's used to create Car manulas for certain cars


    - SOLUTION 1:


                                            ________
                                            | Car  |
                                            |______|
                                               ^
                                               |
                              _________________|________________________________
                              |                |                 |             |
                              |                |                 |             |
                        _____________    ______________     _________    __________
                        | SportsCar |    | Saloon     |     | SUV   |    | Rally  |
                        |___________|    |____________|     |_______|    |________|



                                            ___________
                                            | Manual  |
                                            |_________|
                                               ^
                                               |
                              _________________|________________________________
                              |                |                 |             |
                              |                |                 |             |
                        _____________    ______________     _________    __________
                        | SportsCar |    | Saloon     |     | SUV   |    | Rally  |
                        |___________|    |____________|     |_______|    |________|



        - Problem:
            - There are a large number of configuration variables that we have to pass to the constructor when creating a car or car manual object. It's pretty ugly. Also, a large number of the configuration options are not needed most of the time e.g most cars are not convertibles
            - Our library of subclasses is likely to grow very large as more cofiguration variables are added to Car
            - Also, if we, for example, change the wheel size on SportCar, then we;d also have to change the SportsCarManual class

        - SOLUTION:
            - One way of not having to specify all the configuration options when creating a new object would be to create subclasses for each type of car or manual

                                        ________________
                                        | Builder      |
                                        |______________|
                                        | setCarType() |
                                        | setSeats()   |
                                        |______________|
                                               ^
                                               |
                                               |
                                     __________|_____________
                                     |                      |
                                     |                      |
                             ________________     _________________
                             | CarBuilder   |     | ManualBuilder |
                             |______________|     |_______________|
                             | - car        |     | - manual      |
                             |______________|     |_______________|
                             | setCarType() |     | setCarType()  |
                             | setSeats()   |     | setSeats()    |
                             | getCar()     |     | getCar()      |
                             |______________|     |_______________|

                - getCar():
                    return car;

                - getManual():
                    return manual;


        - A car and it's manual are two different objects that don't share a commom interface; however, they can be constrcuted uising the same steps, as each specific component in a car needs to be documented in it's manual. By abstracting the object creation logic into builder classes, we can create cars and manuals by only specifying the steps required to build the specific car or manual

            _______________________________                ________________
            | Director                    |                | Builder      |
            |_____________________________|--------------> |______________|
            | constructSportsCar(builder) |                | setCarType() |
            | contructSUV(builder)        |                | setSeats()   |
            |_____________________________|                |______________|
                                                                  ^
                                                                  |
                                                                  |
                                                        __________|_____________
                                                        |                      |
                                                        |                      |
                                                ________________     _________________
                                                | CarBuilder   |     | ManualBuilder |
                                                |______________|     |_______________|
                                                | - car        |     | - manual      |
                                                |______________|     |_______________|
                                                | setCarType() |     | setCarType()  |
                                                | setSeats()   |     | setSeats()    |
                                                | getCar()     |     | getCar()      |
                                                |______________|     |_______________|

                - contructSUV(builder)():
                    builder.setSeats(2).setType(...)...;

                - getCar():
                    return car;

                - getManual():
                    return manual;

        - The director class is optional in the builder pattern, as the build steps can be specified in the client; but it's often useful for putting common construction routines so that they can be reused throughout your app


    - BUILDER PATTERN UML: From GoF book:

            ________________________________         ________________
            |         Director             |         | Builder      |
            |______________________________|-------> |______________|
            | constructSomethingA(builder) |         | reset()      |
            | constructSomethingB(builder) |         | buildStepA() |
            | constructSomethingC(builder) |         | buildStepB() |
            |______________________________|         | buildStepC() |
                                                     |______________|
                                                           ^
                                                           |
                                                           |
                                                           |
                                                   ________________________
                                                   | ConcreteBuilders     |
                                                   |______________________|-|
                                                   | - result:ProductA    | |-|
                                                   |______________________| | |
                                                   | reset()              | | |
                                                   | buildStepA()         | | |
                                                   | buildStepB()         | | |
                                                   | buildStepC()         | | |
                                                   | getResult():productA | | |
                                                   |______________________| | |
                                                     |______________________| |
                                                       |______________________|


        - Note that above, we are passing a builder to each method in the director class. But it's also fine to store a reference to a builder, and use methods for changing the builder at runtime, like so;

            ____________________________
            |        Director          |
            |__________________________|
            | - builder: Builder       |
            |__________________________|
            | + Director(builder)      |
            | + changeBuilder(builder) |
            | + constructSomethingA()  |
            | + constructSomethingB()  |
            | + constructSomethingC()  |
            |__________________________|

 */

public class Notes {

}
