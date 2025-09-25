package _04_DesignPatterns.Creational.Singleton;

/*

    NOTES:
    - Singleton pattern:
        - Is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. The single instance is commonly used for managing shared resources, configuration settings, or logging functionality within an application

        - A common usecase of the Singleton pattern is to use a single global instance of a db object throughout an application. This means that all clients that need to connnect to a db will retreve the same db object, and not be creating new, separate ones. The db object is only created once, the first time it's needed, and then all other clients that need to connect and query the db will use this same object



    - CHALLENGE:
        - Here's a user making a request to fetch some products. There are two classes - UserAuthentication and Products. Both require fetching things from the same db. Notice that we are not using the 'new' keyword to get the db object, we are using a method caled getInstance() that returns the exact db object throughout the application, ensuring that we always use a single db connection

                                     _________________________       _________________________
                     User requests   |      Authenticate     |       |      Products         |
                       products      |        user           |------>|                       |
            USER  ------------------>|_______________________|       |_______________________|
                                     | db = DB.getInstance() |       | db = DB.getInstance() |
                                     |                       |       |                       |
                                     |_______________________|       |_______________________|


             --> SAME DB INSTANCE:
                - db = DB.getInstance()

        - You may be wondering why we can't just create a new db object everytime we need to connect to the db. Here are some good reasons to use a single global db object in all clients:
            1.  Resource Efficiency: Db connections and resources are typically limited and can be expensive to establish. By using a single instance of a db object, you minimize the overhead of creating and managing multiple connections, optimizing resource utilization
            2. Consistency and State management: Having a single db instance ensures consistent state management and transactional handling across different parts of the application. Changes made to the db state are visible universally within the application, avoiding inconsistencies that could arise from mutliple db instances
            3. Simplified Configuration and Management: With a singleton db instance, configuration settings such as connection parameters, credentials and initializtion logic are centralized and managed in one place. This simplifies application setup and maintenance
            4. Performance Optimization: By reusing a single db instance, you can optimize db query performance and reduce latency associated with establishing new connections or reinitializing db resources

        - The singleton pattern is great for storing app configuration settings, logging configuration, session information, authentication tokens - and making this information available globally via a single instance, ensuring that it's the same throughout the app

        - Say that we need to keep an AppSettings object, that storess global variables such as the name of the app, the db configuration (e.g the db we are using, username, password) and logger settings (e.g the file location of our log file, the format -  e.g text vs JSON). We need to create only a single instance of this object throughout the app to ensure that it only needs to be configured once in one place, and to ensure consistency throughout the app

 */

public class Notes {

}