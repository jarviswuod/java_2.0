package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - State pattern:
      - Allows an object to behave differently depending on the state it is in


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

                ____________________       ____________________
                | Document         |       |  State           |
                |__________________|<>---->|__________________|
                | state: State     |       |  publish():      |
                | currentUserRole  |       |__________________|
                |__________________|                ^
                | publish():       |                |
                |__________________|                |
                                           ____________________
                                           |  Draft           |
                                           |__________________|-|
                                           |  doc: Document   | |-|
                                           |__________________| | |
                                           |  publish():      | | |
                                           |__________________| | |
                                             |__________________| |
                                               |__________________|


            - Document class keeps reference to (is composed of) a State object. Notice that we are using polymorphism as the 'state' field can be any of the concrete state classes (Draft, Moderation, Published). We are coding against an interface not a concrete class

            - In Document, the publish() method calls state.publish() that is, it delegates the work to the concrete state object. This is good because our solution now satisfies the Open-Closed Principle such that if we want to add a new state we'll just create the state concrete class implementing the State interface. i.e extending our codebase without having to modify any current classes
            
            - The Document class stores a reference to one state concrete classes to represent the current state that it's in. Then, instead of Document implementing state-specific behaviour by itself, it delegates all the state-related work to the state object that it has a reference to



    - STATE PATTERN UML: From GoF book:

                ___________________            ___________________
                |  Context        |            |  State          |
                |_________________|<>--------->|_________________|
                |  - state: State |            |  doThis():      |
                |_________________|            |  doThat():      |
                |  + context()    |            |_________________|
                |  + setState():  |                   ^
                |  + doThis():    |                   |
                |  + doThat():    |                   |
                |_________________|       ____________________________
                                          |  ConcreteStates          |
                                          |__________________________|-|
                                          |  - context: Context      | |-|
                                          |__________________________| | |
                                          |  + setContext(context):  | | |
                                          |  + doThis():             | | |
                                          |  + doThat():             | | |
                                          |__________________________| | |
                                            |__________________________| |
                                              |__________________________|


    - WHEN TO USE A STATE PATTERN:
      - A good indication of when you should use a State pattern is when you have a class that behaves differently depending on it's state and you have a large number of conditionals/ if else statements in the methods



    - PROS AND CONS OF STATE PATTERN:
      + It improves readablility and simplicity of the context class by eliminating conditionals that satisfies the SRP by abstrating state specific logic into separate classes plus it also satisfies the OCP because we can introduce new states without modifying existing classes

      - The state pattern can be an overkill (consider a simple stop watch with ONLY one boolean variable)

 */

public class Notes {

}
