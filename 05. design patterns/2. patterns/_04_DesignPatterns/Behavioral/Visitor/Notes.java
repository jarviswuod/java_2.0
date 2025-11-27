package _04_DesignPatterns.Behavioral.Visitor;

/*

    NOTES:
    - Visitor pattern:
        - Is a behavioral pattern that separates algorithms from an object structure on which it operates on


    - CHALLENGE:
        - Say that you are a developer for a marketing agency that has differenct types of clients:
            - Restautants
            - Law firms
            - Retailers

        - Your manager comes to you and says that they need the ability to send a specialised email with marketing tips for each  of the different clients; Example:
            - Restaurants needs tips on how they can better market their food better but law firms don't
            - Law firms tips to improve their online reviews
            - Retailers tips to improve their product descriptions



    - SOLUTION 1:
        - It seems a good idea to add an abstract method sendEmail(), to Client then implement that method in each concrete client

                ________________           ________________
                | Client       |           | RetailClient |
                |______________|<----------|______________|-|
                | name()       |           | sendEmail()  | |-|
                | email()      |           | getEmail()   | |-|
                |______________|           |______________| | |
                | sendEmail()  |             |______________| |
                | getEmail()   |               |______________|
                |______________|


        - This appears to be a nice elegant solution, but the manager comes back and says that they need a way to export clients as PDFs and XML. You realize that your mananger is going to keep coming to you asking more and more features for clients

        - PROBLEM:
            - We are breaking the open-close principle; everytime we want to add new functionality, we have to open up our code for modification
            - We are also violationg SRP, as clients are not responsible for;
                - Storing clients infomation
                - Sending email &
                - Exporting clients

            - Also, initially clients were simple, plain and straightforward, but adding the abillity to send email means adding 3rd party library(Gmail/Outlook), this easily breaks our previous working code



    - SOLUTION 2: Visitor Pattern;
        - The Visitor Pattern separates algorithms or behaviours from the objects on which they operate on hence a good solution for our problem
        - To solve for challenges in SOLUTION 1, we need to extract behaviours outside of the client classes on which they operate

                ___________________                _______________________________
                | Client          |                | Visitor                     |
                |_________________|--------------> |_____________________________|
                | name()          |                | visitLaw(Law)               |
                | email()         |                | visitRestaurant(Restaurant) |
                |_________________|                | visitRetail(Retail)         |
                | sendEmail()     |                |_____________________________|
                | accept(Visitor) |                               ^
                |_________________|                               |
                        ^                                         |
                        |                          _______________________________
                        |                          | EmailVisitor                |
                ___________________                |_____________________________|-|
                | RetailClient    |                | visitLaw(Law)               | |-|
                |_________________|-|              | visitRestaurant(Restaurant) | | |
                | accept(Visitor) | |-|            | visitRetail(Retail)         | | |
                |_________________| | |            |_____________________________| | |
                  |_________________| |              |_____________________________| |
                    |_________________|                |_____________________________|


        - The behaviors have been abstracted into the ConcreteVisitor classes, which can be passed to the objects that they operate on



    - VISITOR PATTERN UML: From GoF book:

                ___________________                 ____________________________
                | Element         |                 | Visitor                  |
                |_________________|---------------> |__________________________|
                | accept(Visitor) |                 | visitA(ConcreteElementA) |
                |_________________|                 | visitB(ConcreteElementB) |
                         ^                          |__________________________|
                         |                                      ^
                         |                                      |
                ____________________                            |
                | ConcreteElementA |                 ____________________________
                |__________________|-|               | ConcreteVisitorA         |
                | accept(Visitor)  | |-|             |__________________________|-|
                |__________________| | |             | visitA(ConcreteElementA) | |-|
                  |__________________| |             | visitB(ConcreteElementB) | | |
                    |__________________|             |__________________________| | |
                                                       |__________________________| |
                                                         |__________________________|

        - Note:
            - The design patterns are not super rigid; Example;
                - In our case, the Element class is an abstract class and not an interface, because we want to provide some common fields and some methods to all clients

 */

public class Notes {

}
