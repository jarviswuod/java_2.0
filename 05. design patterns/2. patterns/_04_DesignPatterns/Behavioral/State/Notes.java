package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - State pattern:
      - Allows an object to behave differently depending on the state it is in


    - CHALLENGE:
        - Say you're writing a blog post using the popular Content Management System(CMS), wordpress. The document can be in one of three states; Draft, Moderation(under review by an admin) and Published. There are three types of user roles; Reader, Editor, and Admin
        - You are tasked to build sample version of the CMS; please not, Only Admin can publish documents


    - SOLUTION 1: Conditional If-else statements;
        - First let's create a simple solution that uses if else statement to check the current state of the document and weather it can be upgraded. DETAILS UNDER EXPLANATION CLASS



    - SOLUTION 2: Using the State Pattern;
        - Intro:
            - The State Pattern suggests that we should create state classes for each possible state of the Document object then have state-specific logic into the classes(Draft, Moderation, Published)

                ____________________            ____________________
                |  Document        |            |  State           |
                |__________________|<>--------->|__________________|
                |  state: State    |            |  publish():      |
                |  currentUserRole |            |__________________|
                |__________________|                  ^
                |  publish():      |                  |
                |__________________|                  |
                                              ____________________
                                              |  Draft           |
                                              |__________________|-|
                                              |  doc: Document   | |-|
                                              |__________________| | |
                                              |  publish():      | | |
                                              |__________________| | |
                                                |__________________| |
                                                  |__________________|


            - Document class keeps reference to (is composed of) a State object. Notice that we are using polymorphism, as the 'state' field can be any of the concrete state classes (Draft, Moderation, Published), as we are coding to an interface, not concrete classes

            - In Document, the publish() method calls state.publish() that is, it delegates the work to the concrete state object. Why is this good? Because our solution now satisfies the Open-Closed Principle such that if we want to add a new state we just create the state concrete class implementing the State interface. This means extending our codebase (new classes) without having to modify any current classes (Document)
            
            - The Document class stores a reference to one state concrete classes to represent the current state that it's in, then, instead of Document implementing state-specific behaviour by itself, it delegates all the state-related work to the state object that it has a reference to



    - STATE PATTERN UML: From GoF book:
        - This is the State pattern; The abstract names that each class would be in the State pattern:

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
      - A good indication of when you should use a State pattern is when you have a class that behaves differently depending on it's state and you have a large number of conditionals/ if else statements in the methods. A State pattern can be used with abstract classes to reduce duplication



    - PROS AND CONS OF STATE PATTERN:
      + It improves readablility and simplicitly of the context class by eliminating conditionals that satisfies the Single Responsibility Principle by abstrating state specific logic into separate classes plus it also satisfies the Open-Closed Principle because we can introduce new states without modifying existing classes

      - The state pattern can be an overkill (consider a simple stop watch with ONLY one boolean variable)

 */

public class Notes {

}
