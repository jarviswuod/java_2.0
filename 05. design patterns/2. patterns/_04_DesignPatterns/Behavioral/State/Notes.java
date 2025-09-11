package _04_DesignPatterns.Behavioral.State;

/*

    NOTES:
    - State pattern: Allows an object to behave differencly depending on the state it is in

    - Example:
        - Say you're writing a blog post using the popular contnet management system, wordpress. THe document or post can be in one of three states;
            1. Draft
            2. Moderation (under review by an admin)
            3. Published

        - There are three types of user roles; Only Admin can publish documents
            1. Reader
            2. Editor
            3. Admin

        - First let's create a simple solution that uses if else statements to check the current state of the document to see wheather the state of the document should be upgraded. We'll also create a couple of enums to store the possible docuemt states and user roles

        - CODE EXPLANATION PART 1:
            - 

        - Solution with State Pattern:
            - The State Pattern suggests that we should create state classes for each possible state of the Document object, and extract all state-specific logic into these classes

            - The Document class will store a reference to one of the state classes to represent the current state that it is in. Then, instead of Document implementing state-specific behavioir by itself, it delegate al the state-realated work to the state object that it has a reference to:

                |----------------------|            |----------------------|
                |  Document            |            |  State               |
                |----------------------|<>--------->|----------------------|
                |  state               |            |  publish():          |
                |  currentUserRole     |            |----------------------|
                |----------------------|                   ^
                |  publish():          |                   |
                |----------------------|                   |
                                                    |-------------------|
                                                    |  Draft            |
                                                    |-------------------|-|
                                                    |  document         | |-|
                                                    |-------------------| | |-|
                                                    |  publish():       | | | |
                                                    |-------------------| | | |  
                                                      |-------------------| | |  
                                                        |-------------------| |
                                                          |-------------------|

        - Above, 'Document' keeps reference to (is composed of) a State object. Notice that we are using polymorphism, as the 'state' field can be any of the concrete state classes (Draft, Moderation, Published), as we are coding to an interface, not concrete classes

        - In Document, the publish() method calls state.publish() - it delegates the work to the concrete state object. Why is this good? Because our solution now satisfies the Open/Closed Principle: if we want to add a new state, we create state class that implements the 'State' interface -  we extend our codebase (add new classes) without having to modify any current classes ('Document' in our case)

        - 

                |----------------------|            |-----------------|
                |  Context             |            |  State          |
                |----------------------|<>--------->|-----------------|
                |  - state             |            |  doThis():      |
                |----------------------|            |  doThat():      |
                |  + context()         |            |-----------------|
                |  + setState():       |                   ^
                |  + doThis():         |                   |
                |  + doThat():         |                   |
                |----------------------|            |--------------------------|
                                                    |  ConcreteStates          |
                                                    |--------------------------|-|
                                                    |  - context               | |-|
                                                    |--------------------------| | |-|
                                                    |  + setContext(context):  | | | |
                                                    |  + doThis():             | | | |
                                                    |  + doThat():             | | | |
                                                    |  + doThat():             | | | |
                                                    |--------------------------| | | |
                                                      |--------------------------| | |
                                                        |--------------------------| |
                                                          |--------------------------|
    - 

 */

public class Notes {

}
