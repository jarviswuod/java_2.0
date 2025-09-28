package _01_Creational;

/*

    NOTES:
    - Is a creational design pattern that allows to create a new objects by copying or cloning existing ones
    - It focuses on constructing new instances by duplicating existing ones, minimizing the object creation overhead

    - 2 Main actors in Prototype;
        - Main interface Prototype:
            - It defines a clone method

        - A Concrete Prototype:
            - A subclass or prototype interface implements the clone methods to create it's copies


    - Advantages and Disadvantages
        - Advantages:
            - Object creation efficiency: Cloning of objects reduces the overhead associated with recreating and initializing objects from scratch significantly, this results in more streamline and efficient process especially when object initialization is resource intensive

            - Flexibility: It enhances flexibility of the development process. developers can create new object instances by simply cloning existing prototypes. This ability to generate new  objects on the fly contributes to a more agile and adaptable development environment.


        - Disadvantages:
            - Circular dependency: Implementing the prototype pattern can become complex and tricky if the object that needs to be cloned has a circles dependency. This situation requires careful handling to ensure the the pattern is implemented effectively without introducing bugs or inconsistencies in the application's behavior

 */

public class _04_Prototype {

}
