package _04_DesignPatterns.Behavioral.Momento;

/*

    NOTES:
    - Momento Design Pattern:
        - Is a behavioral design pattern that captures and externalizes the internal state of an object without breaking it's encapsulation
        - It allows you to save and restore state of an object providing the ability to undo or rollback changes and also save history of the state
        - Example:
            - Implementing an undo feature used in most text editors, such as Microsoft(MS) word


    - CHALLENGE:
        - Sample example to implement
                1. Add a title to the document: "Test Title"
                2. Write some text: "Hello there, my name is Dan"
                3. Change the title of the document to "The Life of a Developer. My Memories"



    - SOLUTION 1:
        - A simple way to implement this text editor in code would be to create a single Editor class and have a field for title and content, and also have a field that stores each of the previous values for each field in some list

                ________________________
                |  Editor              |
                |______________________|
                |  title: String       |
                |  prevTitle: List     |
                |  content: String     |
                |  prevContent: List   |
                |______________________|

        - ISSUE:
            - With this solution, every time we add a new field, e.g **author**, **data**, **isPublised**, we have to keep storing list of previous states for each field
            - Another issue is, how would we implement the 'undo' feature? If the user changed the **title** then changed the **content**, then pressed 'undo', the current implementation has no knowledge of what the user did last - did they change **title** or **content**?



    - SOLUTION 2:
        - Instead of having multiple fields in this Editor class, we create a separate class to store the state of our Editor at a given time:

                ________________________                ________________________
                |  Editor              |                |  EditorState         |
                |______________________|<>------------->|______________________|
                |  title: String       |                |  title: String       |
                |  content: String     |                |  content: String     |
                |  prevStates: List    |                |______________________|
                |______________________|

            - Note:
                - The composition relationship Editor is composed of or has field of, the EditorState class


        - This is a good solution as we can undo multiple times while not polluting the Editor class with too many fields
        - ISSUE:
            - This solution is violating the SRP, as our Editor class currently has multiple responsibilities;
                1. State management
                2. Providing the features that we need from an editor



    - SOLUTION 3: MEMENTO PATTERN
        - We should take all the state management stuff out of Editor and put it somewhere else

            ________________________       ____________________
            | Editor               |       | EditorState      |
            |______________________|------>|__________________|
            | title: String        |       | title: String    |
            | content: String      |       | content: String  |
            |______________________|       |__________________|
            | createState():       |                ^
            | restore(EditorState) |                |
            |______________________|                |
                                                    <>
                                             __________________
                                             | History        |     backup():
                                             |________________|         - states.add(editor.createState())
                                             | states: List   |
                                             | editor: Editor |     undo():
                                             |________________|         - last = states.last()
                                             | backup():      |         - states.remove(last)
                                             | undo():        |         - editor.restore(last)
                                             |________________|


            - The createState() method returns an EditorState object, hence the dotted line arrow (dependency relationship). History has a field with a list of EditorStates, hence the diamond acrosss(composition relationship)



    - MEMENTO PATTERN UML: From GoF book:

                ________________________             ____________________
                | Originator           |             | Memento          |
                |______________________|------------>|__________________|
                | content: String      |             | content: String  |
                |______________________|             |__________________|
                | createState():       |             |                  |
                | restore(EditorState) |             |__________________|
                |______________________|                    ^
                                                            |
                                                            |
                                                            <>
                                                      _________________
                                                      | Caretaker     |
                                                      |_______________|
                                                      | states: List  |
                                                      |_______________|
                                                      | push():       |
                                                      | pop():        |
                                                      |_______________|

            - NOTE:
                - Our solution differs slightly from the above pattern, as our Caretaker(History) class also has a field that stores a reference to the Editor; this means the History class can restore the Editor's state when the user clicks 'undo'


    - WHEN TO USE THE MEMENTO PATTERN:
        - To be used when you want to produce snapshots of an object's state to be able to restore the object to a previous state
        - It's commonly used pattern for implementing the 'undo' feature, and so provides a common solution that a team of developers can quickly understand and get on the same page with


    - PROS AND CONS OF MEMENTO PATTERN:
        +  You can simplify the Originator's code by letting the Caretaker maintain the history of the Originator's state, satisfying the SRP

        -  The app might consume a lot of RAM if lots of Mementos are created

 */

public class Notes {

}
