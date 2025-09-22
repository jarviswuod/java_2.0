package _04_DesignPatterns.Structural.Flyweight;

/*

    NOTES:
    - Flyweight pattern:
        - Is a structural design pattern that aims to minimize memory usage by sharing common state betweeen multiple objects, allowing efficient handling of large numbers of lightweight objects with shared characteristics


    - CHALLENGE:
        - Say that we have a farming game that includes different types of crops, such as potatoes, carrots and wheat. Each crop is represented by a Crop object, that includes it's X ad Y coordinates, the type of crop, and an icon;

                ______________________
                | Crop               |
                |____________________|
                | x: int             |
                | y: int             |
                | cropType: CropType |
                | icon: byte         |
                |____________________|


    - SOLUTION 1:
        - The problem with the above solution is that for every carrot created, we are storing a new object with all of the information about a carrot stored within that object. This means that if we create 1000 carrots, then we will be storing 1000 carrot icons in RAM - that's going to take up lots of memory, and many maobile devices wil struggle to handle that

        - What if we could share icons between crop objects of the same type...

        - If a carrot is created with the Crop class, then it's icon and cropType fields will remain constant for the lifetime of the object, but it's x and y coordinates will varry, as the crop can be harvested and moved around

        - State that remains the same throughout the object's life is called "internal state". State that can change is called "extrinsic state"

                ______________________
                | Crop               |
                |____________________|
                | x: int             |          Extrinsic state
                | y: int             |          Extrinsic state
                | cropType: CropType |          Intrinsic state
                | icon: byte         |          Intrinsic state
                |____________________|

        - So, if we can extract the intrinsic state out of Crop, and place it into a new object, called CropIcon, then we would only need to create three CropIcon objects (for potato, carrot and what) in our application, even if there are 1000s of crops in the game

        - We can then, for example, have just one carrot icon object store in memory, then all crops o type carrot can make reference, or reuse, that carrot icon object throughout the game


                ___________              _____________
                | Crop    |<>----------->| CropIcon  |
                |_________|              |___________|
                | x: int  |              | iconType  |
                | y: int  |              | icon      |
                |_________|              |___________|

            - An object that contains only intrisic state is called a FlyWeight

            - But we shouldn't create CropIcon objects directly, we can create a factory class that cretes an icon, depending on the icon type, and cached that icon in memory, ensuring that it's only stored in one place


                            ___________              _____________
                            | Crop    |<>----------->| CropIcon  |
                            |_________|              |___________|<-------------|
                            | x: int  |              | iconType  |              |
                            | y: int  |              | icon      |              |
                            |_________|              |___________|              |
                                                                                |
                                                                                |
                ______________________              ______________________      |
                | CropSerice         |------------->| CropIconFactory    |<>----|
                |____________________|              |____________________|
                | getCrops()         |              | getCropIcon(type)  |
                |____________________|              |____________________|




    - FLYWEIGHT PATTERN UML: From GoF book:
                ________________________________________      __________________________
                | Context                              |----->| Flyweight              |<-----|
                |______________________________________|      |________________________|      |
                | uniqueState                          |      | repeatingState         |      |
                | flyweight                            |      |________________________|      |
                |______________________________________|      | operation(uniqueState) |      |
                | context(repeatingState, uniqueState) |      |________________________|      |
                | operation()                          |                                      |
                |______________________________________|                                      |
                                |                           __________________________        |
                                |-------------------------->| Flyweight              |        |
                                                            |________________________|<>------|
                                                            | repeatingState         |
                                                            |________________________|
                                                            | operation(uniqueState) |
                                                            |________________________|

        - Context:
            - context();
                this.uniqueState = uniqueState
                this.flyweight = factory.getFlyweight(repeatingState)

            - operation();
                - flyweight.operation(uniqueState)



 */

public class Notes {

}
