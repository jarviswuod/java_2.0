package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - State pattern:
      - Is a behavioral design pattern that allows an object to change it's behavior when it's internal state changes 


    - CHALLENGE:
        - Say you're writing a blog post using a popular Content Management System(CMS), wordpress. The document can be in one of three states; Draft, Moderation(under review by an admin) and Published. There are three types of user roles; Reader, Editor, and Admin
        - You are tasked to build simple version of the CMS
          - Note:
            - Only Admin can publish documents


    - SOLUTION 1: Conditional If-else statements;
        - First let's create a simple solution that uses if else statement to check the current state of the document and weather it can be upgraded
        - More details under "explanation"



    - SOLUTION 2: Using State Pattern;
        - Intro:
            - The State Pattern suggests that we should create state classes for each possible state of the Document object then have state-specific logic into the classes(Draft, Moderation, Published)

                ____________________       _________________
                | Document         |       | State         |
                |__________________|<>---->|_______________|
                | state: State     |       | publish():    |
                | currentUserRole  |       |_______________|
                |__________________|                ^
                | publish():       |                |
                |__________________|                |
                                             _________________
                                             | Draft         |
                                             |_______________|-|
                                             | doc: Document | |-|
                                             |_______________| | |
                                             | publish():    | | |
                                             |_______________| | |
                                               |_______________| |
                                                 |_______________|


            - Document class keeps reference to (is composed of) a State object. Notice that we are using polymorphism as the 'state' field can be any of the concrete state classes (Draft, Moderation, Published). We are coding against an interface not a concrete class

            - In Document, the publish() method calls state.publish() that is, it delegates the work to the concrete state object. This is good because our solution now satisfies the Open-Closed Principle such that if we want to add a new state we'll just create the state concrete class implementing the State interface. i.e extending our codebase without having to modify any current classes
            
            - The Document class stores a reference to one state concrete classes to represent the current state that it's in. Then, instead of Document implementing state-specific behaviour by itself, it delegates all the state-related work to the state object that it has a reference to



    - STATE PATTERN UML: From GoF book:

                __________________           ___________________
                | Context        |           |  State          |
                |________________|<>-------->|_________________|
                | - state: State |           |  doThis():      |
                |________________|           |  doThat():      |
                | + context()    |           |_________________|
                | + setState():  |                   ^
                | + doThis():    |                   |
                | + doThat():    |                   |
                |________________|        __________________________
                                          | ConcreteStates         |
                                          |________________________|-|
                                          | - context: Context     | |-|
                                          |________________________| | |
                                          | + setContext(context): | | |
                                          | + doThis():            | | |
                                          | + doThat():            | | |
                                          |________________________| | |
                                            |________________________| |
                                              |________________________|


    - WHEN TO USE A STATE PATTERN:
      - A good indication of when you should use a State pattern is when you have a class that behaves differently depending on it's state and you have a large number of conditionals/ if else statements in the methods



    - PROS AND CONS OF STATE PATTERN:
      + It improves readablility and simplicity of the context class by eliminating conditionals that satisfies the SRP by abstrating state specific logic into separate classes plus it also satisfies the OCP because we can introduce new states without modifying existing classes

      - The state pattern can be an overkill (consider a simple stop watch with ONLY one boolean variable)

 */

public class Notes {

}
