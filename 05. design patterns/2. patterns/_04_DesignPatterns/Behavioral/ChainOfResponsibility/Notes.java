package _04_DesignPatterns.Behavioral.ChainOfResponsibility;

/*

    NOTES:
    - Chain of Responsibility:
        - The pattern allows building a chain of objects to handle a request. A request is passed through a chain of handlers each capable of either handling the request or passing it to the next handler in the chain.


    - CHALLENGE:
        - Let's say we have a web page that contains some information that only admins of the website can access, such as a page that allows an admin to manage the website's users. e.g create new users, get informatiOn, update users information etc.



    - SOLUTION 1: Without CHAIN OF RESPONSIBILITY
        - Say that a user makes a request to the webstie's server, but before returning the web page, the users data must be validated(trim any whitespace around user-entered data), authenticate the user (e.g check their username and password is correct) and then log some information onto the server about this request. If any of those steps fail, then 'access denied' is returned to the user

            ____________         ___________________________        _____________
            | Request  |         | Request                 |        | WebPage   |
            |__________|-------> |_________________________|------->|___________|
            |          |         | Handler 1: Validate     |        |           |
            |__________|         | Handler 2: Authenticate |        |___________|
                                 | Handler 3: Log          |
                                 |_________________________|
                                                |
                                                |
                                                v
                                    ________________________
                                    | Access Denied        |
                                    |______________________|



    - SOLUTION 1: Without CHAIN OF RESPONSIBILITY
        - Instead of having all of our request processinG logic inside of the WebServer.handle() method, we can create a processing pipline - a chain of objects:

            ____________     _______________     __________________     ________________     ________________
            | Request  |     | Validator   |     | Authenticator  |     | Logger       |     | WebPage      |
            |__________|---> |_____________|---> |________________|---> |______________|---> |______________|
            |          |     | validate()  |     | authenticate() |     | log()        |     |              |
            |__________|     |_____________|     |________________|     |______________|     |______________|
                                    |                    |                    |
                                    |                    |                    |
                                    v                    v                    v
                            __________________  __________________       __________________
                            | Access Denied  |  | Access Denied  |       | Access Denied  |
                            |________________|  |________________|       |________________|


            - Each object only knows about the next object in the chain. First, a request is passed to the first object in the chain( Validator), if this request is successful it passes the request to the next object in the chain; if not successful, it will stop processing right there, so the other objects aren't used



    - CHAIN OF RESPONSIBILITY UML: From GoF book:

            ___________________             _______________________
            | WebServer       |             | Handler             |
            |_________________|<>---------->|_____________________|
            | handle(request) |             | setNext(L: Handler) |
            |_________________|             | handle(request)     |
                                            |_____________________|
                                                      ^
                                                      |
                    __________________________________|________________
                    |                        |                        |
            ________|__________     _________|________      __________|________
            | Validator       |     | Authenticator   |     | Logger          |
            |_________________|     |_________________|     |_________________|
            | handle(request) |     | handle(request) |     | handle(request) |
            |_________________|     |_________________|     |_________________|


        - We have an abstract class called Handler that has a reference to itself - it has a field called 'next' of type Handler. so with this, each handler can know about the next handler in the chain (a LinkedList)
        - handle() is an abstract method as the time of implementing Handler class we don't know how to handle a request - we determine/ implement this in our concrete handlers( Validator, Authenticator, Logger)

        - WebServer has a reference to the first handler in the chain
            - Note: WebServer is not talking directly to the concrete handlers, it's talking to the handler interface. So it's completely decoupled from the concrete implmenetations

        - This satisfies open-closed principle, if we want to remove logger, we don't have to go to the handler() method on WebServer and change it's implementation
        - Also, if we want to add a new process, we can create a new class that extends Handler, then add it to our chain - Satisfying OCP



    - GoF implementation of Chain of Responsiblility:

            ______________________
            | Handler            |           ______________
            |____________________|<----------|  Client    |
            | next: Handler      |           |____________|
            |____________________|
            | setNext(L:Handler) |            h1 =  new Handler1() 
            | handle(request)    |            h2 =  new Handler2() 
            |____________________|            h3 =  new Handler3() 
                    ^                          h1.setNext(h2) 
                    |                          h2.setNext(h3) 
            ________|___________               h1.handle(request) 
            | ConcreteHandlers |
            |__________________|
            | handle(request)  |
            |__________________|

 */

public class Notes {

}
