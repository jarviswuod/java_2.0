package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - State pattern:
      - Allows an object to behave differently depending on the state it is in

    - CHALLENGE:
        - Say you're writing a blog post using the popular content management system, wordpress. The document/ post can be in one of three states;
            1. Draft
            2. Moderation (under review by an admin)
            3. Published

        - There are three types of user roles; Only Admin can publish documents
            1. Reader
            2. Editor
            3. Admin


    - SOLUTION 1:
        - First let's create a simple solution that uses if else statements to check the current state of the document to see wheather the state of the document should be upgraded. We'll also create a couple of enums to store the possible docuemt states and user roles



    - SOLUTION 2:
        - Solution with State Pattern:
            - The State Pattern suggests that we should create state classes for each possible state of the Document object, and extract all state-specific logic into these classes (Draft, Moderation, Published)

            - The Document class will store a reference to one of the state classes to represent the current state that it is in then, instead of Document implementing state-specific behaviour by itself, it delegates all the state-related work to the state object that it has a reference to:

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
                                              |  document        | |-|
                                              |__________________| | |
                                              |  publish():      | | |
                                              |__________________| | |
                                                |__________________| |
                                                  |__________________|

        - Above, 'Document' keeps reference to (is composed of) a State object. Notice that we are using polymorphism, as the 'state' field can be any of the concrete state classes (Draft, Moderation, Published), as we are coding to an interface, not concrete classes

        - In Document, the publish() method calls state.publish() - it delegates the work to the concrete state object. Why is this good? Because our solution now satisfies the Open/Closed Principle: if we want to add a new state, we create state class that implements the 'State' interface - we extend our codebase (add new classes) without having to modify any current classes ('Document' in our case)



    - STATE PATTERN UML:
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
                |_________________|                   |
                                          ____________________________
                                          |  ConcreteStates          |
                                          |__________________________|-|
                                          |  - context               | |-|
                                          |__________________________| | |
                                          |  + setContext(context):  | | |
                                          |  + doThis():             | | |
                                          |  + doThat():             | | |
                                          |__________________________| | |
                                            |__________________________| |
                                              |__________________________|


    - WHEN TO USE A STATE PATTERN:
      - A good indication of when you should use a State pattern is when you have a class that behaves differently depending on it's state and you have a large number of conditionals/ if else statements in the methods. A state pattern can be used with abstract classes to reduce duplication


    - PROS AND CONS OF STATE PATTERN:
      - The state pattern can be an overkill (consider a simple stop watch with one boolean variable)

      + It improves readablility and simplicitly of the context class by eliminating conditionals that satisfies the Single Responsibility Principle by abstrating state specific logic into separate classes plus it also satisfies the Open-Closed Pringple because we can introduce new states without modifying existing classes

 */

public class Notes {

}
