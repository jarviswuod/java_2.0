package _04_DesignPatterns.Behavioral.Visitor;

/*

    NOTES:
    - Visitor pattern:
        - It separates the algorithms/behaviours from an object structure on which it operates on


    - Sample Usecase:
        - Say that you are a developer for a marketing agency that has differenct types of clients:
            - Restautants
            - Law firms
            - Retailers

        - Your manager comes to you and says that they ned the ability to send a specialised email with marketing tips for each  of the different clients; example:
            - Restaurants needs tips on how they can better market their food better but las firms don't
            - Law firms get tips on how to improve their online reviews
            - Retailers get tips on how to improve their product descriptions

        - SOLUTION 1:
            - It seems a good idea to add an abstract method sendEmail(), to Client() then implement that method in each concrete client

                            _____________________
                            |  Client           |
                            |___________________|
                            |  name()           |
                            |  email()          |
                            |___________________|
                            |  sendEmail()      |
                            |  getEmail()       |
                            |___________________|
                                    ^
                                    |
                                    |
                            _____________________
                            |  RetailClient     |
                            |___________________|-|
                            |  sendEmail()      | |-|
                            |  getEmail()       | |-|
                            |___________________| | |
                              |___________________| |
                                |___________________|


            - This appears to be a nice elegant solution, but the manager comes back and says that they need a way to export  clients as PFD's and XML. You relaize that you mananger is goind to keep coming to you asking more and more features for clients
            - Following our current design, everytime we want to ass new fucntiolaity, we have to open up our code for modifiaction, breaking he open-close principle. We are also violationg SRP, as clients are not responsible for storing cleitns info, sending email and exporting

            - Also, intiriallyu cleitns were simple , plain and straightforward, but addign the abillity to send email means adding 3rd party library code into these classes, taht calles email cleitns like Gmaila dn Outlook. This can easilty break our previous working code

            - SOLUTION:
                - TO solve these issues, we need to etract ehse behaviours outiside of the client classes on which they operate. Remeber, The VIsitor Pattern separated the algorirhtms, or behaviours from the objects on which they operate on ,hence a good solution for our problem


    - SOLUTION 2 Visitor Pattern: UML
        - 

                ____________________                   _______________________________
                | Client           |                   | Visitor                     |
                |__________________|-----------------> |_____________________________|
                | name()           |                   | visitLaw(Law)               |
                | email()          |                   | visitRestaurant(Restaurant) |
                |__________________|                   | visitRetail(Retail)         |
                | sendEmail()      |                   |_____________________________|
                | accept(Visitor)  |                           ^                
                |__________________|                           |                
                        ^                                      |                
                        |                             _______________________________
                        |                             | EmailVisitor                |
                ____________________                  |_____________________________|-|
                | RetailClient     |                  | visitLaw(Law)               | |-|
                |__________________|-|                | visitRestaurant(Restaurant) | | |
                | accept(Visitor)  | |-|              | visitRetail(Retail)         | | |
                |__________________| | |              |_____________________________| | |
                  |__________________| |                |_____________________________| |
                    |__________________|                  |_____________________________|    

        - The behaviours have been abstracted into the concrete visitor classes , which can be passed to the objects that ehy operate on


    - GoF Visitor Pattern: UML
        - 

                ____________________                   ____________________________
                | Element          |                   | Visitor                  |
                |__________________|-----------------> |__________________________|
                | accept(Visitor)  |                   | visitA(ConcreteElementA) |
                |__________________|                   | visitB(ConcreteElementB) |
                        ^                              |__________________________|
                        |                                      ^
                        |                                      |
                ____________________                           |
                | ConcreteElementA |                  ____________________________
                |__________________|-|                | ConcreteVisitorA         |
                | accept(Visitor)  | |-|              |__________________________|-|
                |__________________| | |              | visitA(ConcreteElementA) | |-|
                  |__________________| |              | visitB(ConcreteElementB) | | |
                    |__________________|              |__________________________| | |
                                                        |__________________________| |
                                                          |__________________________|

        - Note:
            - THe design patterns are not super rigid; Example;
                - In our case, the Element class is an abstract class and not an interface, because we want to provide some common fields and some methods methods to all clients


 */

public class Notes {

}
