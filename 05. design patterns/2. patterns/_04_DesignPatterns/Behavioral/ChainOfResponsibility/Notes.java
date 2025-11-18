package _04_DesignPatterns.Behavioral.ChainOfResponsibility;

/*

    NOTES:
    - Chain of Responsibility:
        - Is a pattern allows you to create a chain of objects where each object can either handle a request or pass it along to the next object
        - It decouples the sender of a request from it's receiver enabling multiple objects to handle the request without explicitly specifying which object will process it


    - CHALLENGE:
        - Let's say we have a web page that contains some information that only admins of the website can access say a page that allows an admin to manage the website's users. e.g create new users, get informatiOn, update users information etc



    - SOLUTION 1: Without CHAIN OF RESPONSIBILITY
        - Say that a user makes a request to the website's server, but before returning the web page, the users data must be validated(trim any whitespaces in user-entered data), authenticate the user(check username & password) and then log some information onto the server about this request
        - If any of those steps fail, then 'access denied' is returned to the user

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



    - SOLUTION 2: With CHAIN OF RESPONSIBILITY
        - Instead of having all of our request processing logic inside of the WebServer.handle() method, we can create a processing pipline - a chain of objects:
        - Each object only knows about the next object in the chain


            ____________     _______________     __________________     ________________     ________________
            | Request  |     | Validator   |     | Authenticator  |     | Logger       |     | WebPage      |
            |__________|---> |_____________|---> |________________|---> |______________|---> |______________|
            |          |     | validate()  |     | authenticate() |     | log()        |     |              |
            |__________|     |_____________|     |________________|     |______________|     |______________|
                                    |                    |                      |
                                    |                    |                      |
                                    v                    v                      v
                            __________________  __________________     __________________
                            | Access Denied  |  | Access Denied  |     | Access Denied  |
                            |________________|  |________________|     |________________|


            - First, a request is passed to the first object in the chain(Validator). If the request is processed successfully, it passes the request to the next object in the chain but if not, it will stop processing right there so the other objects aren't used



    - CHAIN OF RESPONSIBILITY UML: GoF Solution:

            ___________________             _______________________
            | WebServer       |             | Handler             |
            |_________________|<>---------->|_____________________|
            | handle(request) |             | setNext(L: Handler) |
            |_________________|             | handle(request)     |
                                            |_____________________|
                                                      ^
                                                      |
                             _________________________|_________________________
                             |                        |                        |
                     ________|__________     _________|________      __________|________
                     | Validator       |     | Authenticator   |     | Logger          |
                     |_________________|     |_________________|     |_________________|
                     | handle(request) |     | handle(request) |     | handle(request) |
                     |_________________|     |_________________|     |_________________|


        - We have an abstract Handler class that has a reference to itself and has a 'next' field of type Handler. With this, each Handler subclass can know about the next Handler in the chain (kind of a LinkedList design)
        - handle() is an abstract method for during Handler class implementing we don't know how to handle a request. Implementation we'll happen in our concrete handlers(Validator, Authenticator, Logger) level

        - WebServer has a reference to the first handler in the chain
        - Note that the WebServer is not talking directly to the concrete handlers, it's talking to the handler interface. So it's completely decoupled from the concrete implmentations. This satisfies OCP in that;
            - To remove logger, we don't have to go to handler() method on WebServer to change it's implementation
            - To add a new process, we can create a new class that extends Handler, then add it to our chain



    - GoF implementation of Chain of Responsiblility:

            ______________________
            | Handler            |           ______________
            |____________________|<----------|  Client    |
            | next: Handler      |           |____________|
            |____________________|
            | setNext(L:Handler) |            h1 =  new Handler1()
            | handle(request)    |            h2 =  new Handler2()
            |____________________|            h3 =  new Handler3()
                    ^                           h1.setNext(h2)
                    |                           h2.setNext(h3)
            ________|____________               h1.handle(request)
            | ConcreteHandler   |
            |___________________|-|
            | handle(request)   | |-|
            |___________________| | |
              |___________________| |
                |___________________|

 */

public class Notes {

}
