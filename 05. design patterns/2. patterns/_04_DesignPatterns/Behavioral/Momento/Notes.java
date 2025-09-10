package _04_DesignPatterns.Behavioral.Momento;

/*

    NOTES:
    - THe momento pattern is used to restrore an object to a previous state

    - A common use case for the Memento Pattern is implementing an undo feature.
    - Used in most text editors, such as Microsoft(MS) word

    - Sample example to implement
            1. Add a title to the document: "Test Title"
            2. Write some text: "Hello there, my name is Dan"
            3. Change the title of the document to "The Life of a Developer. My Memories"

    - IMPLEMENTATION:
        - A simple way to implement this text editor in code would be to create a single Editor class and have a field for title and content, and also have a field that stores each of the previous values for each field in some list

                |----------------------|
                |  Editor              |
                |----------------------|
                |  title:String        |
                |  prevTitle: List     |
                |  Content: String     |
                |  prevContent: List   |
                |----------------------|
        - The problem: Every time we add a new field, e.g author, data, isPublised, we have to keep storing list of prev states(all the changes) for each field. Also, how would we implement the undo feaure? If the user changed the title then changed the content, then pressed undo, the current implementation has not knowledge of what the user did last -  did they change title or content?

        SECOND GUESS:
        - Instead of having multiple fields in this Editor class, we create a separate class to store the state of our editor at a gien time:

                |----------------------|                |----------------------|
                |  Editor              |                |  EditorState         |
                |----------------------|<>------------->|----------------------|
                |  title:String        |                |  title:String        |
                |  Content: String     |                |  Content: String     |
                |  prevStates: List    |                |----------------------|
                |----------------------|
            
        - (Note: The composition relationship Editor is composed of, or has field of, the EditorState class)
        - This is a good solution as we can do undo multiple times and we don't pollute the Editor class with too many fields
        - However, this solution is violating the Single Responsibility Principle, as our Editor class currently has multiple responsibilities;
                1. State management
                2. Providing the features that we need from an editor


        - THIRD GUESS:
            - We should take all the state management stuff out of Editor and put it somewhere else

                |----------------------|                |----------------------|
                |  Editor              |                |  EditorState         |
                |----------------------|--------------->|----------------------|
                |  title:String        |                |  title:String        |
                |  Content: String     |                |  Content: String     |
                |----------------------|                |----------------------|
                |  createState():      |                        ^
                |  restore(state):     |                        |
                |----------------------|                        |
                                                                <>
                                                        |-------------------|
                                                        |  History          |
                                                        |-------------------|
                                                        |  State:List       |
                                                        |  editor: Editor   |
                                                        |-------------------|
                                                        |  backup():        |
                                                        |  undo():          |
                                                        |-------------------|

            - The createState() method returns an EditorState object, hence the dotted line arrow (dependency relationship). History has a field with a list of EditorStates, hence the diamond arros(composition relationship)

        - This is the Memento pattern; The abstract names that each class would be in the memento pattern:

                |----------------------|                |----------------------|
                |  Originator          |                |  Memento             |
                |----------------------|--------------->|----------------------|
                |  Content: String     |                |  Content: String     |
                |----------------------|                |----------------------|
                |  createState():      |                |                      |
                |  restore(state):     |                |----------------------|
                |----------------------|                       ^
                                                               |
                                                               |
                                                               <>
                                                        |-------------------|
                                                        |  Caretaker        |
                                                        |-------------------|
                                                        |  State:List       |
                                                        |-------------------|
                                                        |  pop():           |
                                                        |  push():          |
                                                        |-------------------|

            - These abstract names for the classes in the Memento Pattern come rom the original Gang of Four(GoF) book. Note that our solution differs slightly from the above pattern, as our Caretaker class, History, also has a field that stores a reference to the Editor, so that the Histroy class can restroe the Editor's state when the user clickes undo    
            
        - When to use the Memento Pattern:
            - To be used when you want to produce snapshots of an object's state to be able to restore the object to a previous state
            - It's commonly used pattern for implementing the undo feature, and so provides a common solution that a team of developers can quickly understand and get on the same page with

        - Pros ad Cons of Memento pattern:
            +  You can sinmpligy the originator's code by letting the caretaker maintain the history of the originator's state, satiying the Singleton Responsiblity Principle
            -  The app might consume a lot of RAM if lots of Mementos are created


    - CODE EXPLANATION:
        - The EditorState class is a made final with both it's 2 variables final too;
                public final class EditorState {
                    private final String title;
                    private final String content;
                    private final Instant createdAt;
                    ...
                }

        - The reason for this is to ensure robustness, once an EditorState object is created, it cannot be changed
        - Al fields are final and only have a getter method; this is because will need this 'states'/ detials when we will restore the content and title to the previous states, i.e we will be restoring the Editor class with details we snapped earlier
                public String getTitle() {
                    return title;
                }

                public String getContent() {
                    return content;
                }

        - We have the extra field and method of createdAt, this enables to take the state meta data at that particular moment to give us a little information abou tthe state/ when it was backed up
                private final Instant createdAt;
                public EditorState(String title, String content) {
                    this.title = title;
                    this.content = content;
                    this.createdAt = Instant.now();
                }
                public Instant getCreatedAt() {
                    return createdAt;
                }

        - Inside our Editor class we have a couple of methods
            - This methods takes a snap with Editor's current title and content to help create an EditorState which will be stored in our History (Caretaker)
                    public EditorState createState() {
                        return new EditorState(title, content);
                    }

            - To restore our Editor to our previous state, we create a restore method which takes in an EditorState object and we can simply take values from that State back to our Editor. The restore method restores the Editor to any kind of state
                    public void restore(EditorState state) {
                        title = state.getTitle();
                        content = state.getContent();
                    }


        - Inside out History class (Caretaker), we have a deque which stores a list of all previous EditorState
        We also make reference to our Editor object and then when we construct the History object we need to pass in Editor that the History class is refereing to
                public class History {

                    private final Deque<EditorState> states = new ArrayDeque<>();
                    private final Editor editor;

                    public History(Editor editor) {
                        this.editor = editor;
                    }
                    ***
                }

        - Our backup() methods adds onto the states list the currect state of the Editor, of which we have a createState() method to help us in that
                public void backup() {
                    states.push(editor.createState());
                }

        - The undo() method allows us to restore the editor to it's last backed up state. Just as a safety measure we have to check for any previous EditorState to revert to preventing any runtime Expcetion

                public void undo() {
                    if (states.isEmpty())
                        return;

                    editor.restore(states.pop());
                }
                
        - ShowHistory lists all the backed-up EditorState of our Editor

                public void showHistory() {
                    System.out.println("History: Here is the list of Mementos");

                    for (EditorState editorState : states) {
                        System.out.println(editorState.toString());
                    }
                }

        - We test our Memento solution for the Editor. We pass the Editor into the Histoy object
                public static void main(String[] args) {
                    Editor editor = new Editor();
                    History history = new History(editor);
                }


    - AI IMPROVEMENTS MADE:
        - EditorState:
            - final class and fields
            - Instance for timestamp

        - History:
            - Swapping Stack for Deque interface

            - New:
                public void undo() {
                    if (states.size() <= 0) {
                        return;
                    }

                    EditorState prevState = states.peek();
                    states.pop();
                    editor.restore(prevState);
                }

            - Old:
                public void undo() {
                    if (states.isEmpty())
                        return;

                    editor.restore(states.pop());
                }

 */

public class Notes {

}
