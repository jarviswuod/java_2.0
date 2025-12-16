package _04_DesignPatterns.Creational.Singleton;

/*

    NOTES:
    - Singleton pattern:
        - Is a creational design pattern that ensures that a class only has one instance and provides a global access point to that instance
        - The single instance is commonly used for managing shared resources, configuration settings, or logging functionality within an application



    - Example usecase:
        - A common usecase of the Singleton pattern is to use a single global instance of a db object throughout an application. This means that all clients that need to connnect to a db will retrieve the same db object, and not be creating new, separate ones
        - The db object is only created once, the first time it's needed, and then all other clients that need to connect and query the db will use this same object



    - CHALLENGE:
        - Here's a user making a request to fetch some products. There are two classes; UserAuthentication and Products. Both require fetching things from the same db
        - Notice:
            - We are not using the 'new' keyword to get the db object. We are using a method called getInstance() that returns the exact same db object throughout the application. This ensures that we always use a single db connection

                                     _________________________       _________________________
                     User requests   |      Authenticate     |       |        Products       |
                        products     |          user         |------>|                       |
            USER  ------------------>|_______________________|       |_______________________|
                                     | db = DB.getInstance() |       | db = DB.getInstance() |
                                     |                       |       |                       |
                                     |_______________________|       |_______________________|


                --> SAME DB INSTANCE:
                   - db = DB.getInstance()

        - You may be wondering why we can't just create a new db object everytime we need to connect to the db. Here are some good reasons to use a single global db object in all clients:
            1. Resource Efficiency: Db connections and resources are typically limited and can be expensive to establish. By using a single instance of a db object, you minimize the overhead of creating and managing multiple connections, optimizing resource utilization
            2. Consistency and State management: Having a single db instance ensures consistent state management and transactional handling across different parts of the application. Changes made to the db state are visible universally within the application, avoiding inconsistencies that could arise from mutliple db instances
            3. Simplified Configuration and Management: With a singleton db instance, configuration settings such as connection parameters, credentials and initializtion logic are centralized and managed in one place. This simplifies application setup and maintenance
            4. Performance Optimization: By reusing a single db instance, you can optimize db query performance and reduce latency associated with establishing new connections or reinitializing db resources



    - SOLUTION 2: SINGLETON DESIGN PATTERN;
        - To ensure we have only a single instance of a class(AppSettings), first we have to make the constructor private so we can't use the new operation with this class

                    ___________________
                    |  AppSettings    |
                    |_________________|
                    | - instance      |
                    |_________________|
                    | - AppSettings() |
                    | + getInstance() |
                    | + get()         |
                    | + set()         |
                    |_________________|

            if(instance == null)
                instance = new AppSettings();
                return instance;


        - We also add a private static "getInstance()" instance field that holds an instance of the AppSettings class i.e the class responsible for maintaining a single instance of itself
        - getInstance() is a static method for getting that single instance. Static because static fields are only visible to static methods



    - SINGLETON PATTERN UML: From GoF book:
                    _______________________________
                    |  Singleton                  |
                    |_____________________________|
                    | - instance: Singleton       |
                    |_____________________________|
                    | - Singleton                 |
                    | + getInstance(): Singleton  |
                    |_____________________________|

        - So, to implement the Singleton pattern, you have to:
            1. Make the constructor private, so the 'new' keyword can't be used to create multiple instance of the class
            2. Create a private static instance field to keep reference to the single instance
            3. Create a public static getInstance() for creating that single instance the first time the method is called in the application, then returning that same instance every time the method is called

 */

public class Notes {

}