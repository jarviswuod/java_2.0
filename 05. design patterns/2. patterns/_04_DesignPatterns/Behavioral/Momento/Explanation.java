package _04_DesignPatterns.Behavioral.Momento;

/*

    - CODE EXPLANATION:
        - EditorState class: Memento
            - The EditorState class plus all it's fields(title, content, createdAt) are made final
                - This is because once the EditorState is created it should not be changed, this adds robustness to our code

                    public final class EditorState {
                        private final String title;
                        private final String content;
                        private final Instant createdAt;

                        ...
                    }

            - All fields have ONLY getter methods as we will need the details/states when we restore the Editor class to the previous state we snapped earlier

                    public final class EditorState {

                        public String getTitle() {
                            return title;
                        }

                        public String getContent() {
                            return content;
                        }

                        ...
                    }

            - We added a meta data field **createdAt** this enables us take the exact moment an EditorState instance was created giving us a little information if needed later

                    public final class EditorState {

                        private final Instant createdAt;

                        public EditorState(String title, String content) {
                            this.title = title;
                            this.content = content;
                            this.createdAt = Instant.now();
                        }

                        public Instant getCreatedAt() {
                            return createdAt;
                        }

                        ...
                    }


        - Editor class: Originator
            - Our Editor class has 2 fields (title, content)

                    public class Editor {

                        private String title = "";
                        private String content = "";

                        ...
                    }

            - We create a couple of 2 methods (createState, restore)

                    public class Editor {

                        public EditorState createState() {
                            return new EditorState(title, content);
                        }

                        public void restore(EditorState state) {
                            title = state.getTitle();
                            content = state.getContent();
                        }

                        ...
                    }

                - createState():
                    - Returns an EditorState object and this EditorState takes **title** and **content** of the current Editor state
                    - This mean whenever we create a state, we are just returning the current title & content of the Editor class
                    - This method create a backup with the current state of the current Editor object

                - restore():
                    - It takes in an EditorState object and simply sets the **title** to the EditorState object's **title** and sets **content** to the EditorState object's **content**
                    - This restore() method is used for restoring the Editor to any previous state


        - History class: Caretaker
            - Here we store a list of all the previous states
            - We will make reference to the Editor class *editor* object
            - When we construct the History object we need to pass in the Editor that History class is refering to

                    public class History {

                        private final Deque<EditorState> states = new ArrayDeque<>();
                        private final Editor editor;

                        public History(Editor editor) {
                            this.editor = editor;
                        }

                        ...
                    }

            - We need to create our backup method; What will do over here it just to add to the states list the curent state of our Editor
                - Keep in mind we already have createState() method we created under our Editor to help us with the heavy lifting

                    public void backup() {
                        states.push(editor.createState());
                    }

            - We also have undo() method which allows to restore the Editor to it's last backed-up state
                - We need to perform a check to see if we actually have any backed-up states and then get the last state of our Editor from the states. The restore() method we have is from the Editor class to help us transfer the title and content to the Editor class
                - We then remove this our 'current' state from the states list
                    - NOTE:
                        - Just as a safety measure we have to check for any previous EditorState to revert to preventing any runtime Exceptions

                    public void undo() {
                        if (states.isEmpty())
                            return;

                        editor.restore(states.pop());
                    }

            - We also created the showHistory() method to help visualize a list of all the backed-up EditorState of our Editor

                    public void showHistory() {
                        System.out.println("History: Here is the list of Mementos");

                        for (EditorState editorState : states) {
                            System.out.println(editorState.toString());
                        }
                    }


        - TESTING:
            - We test our Memento solution for the Editor. We pass the Editor into the Histoy object. It all works great

                    public class Main {
                        public static void main(String[] args) {

                            Editor editor = new Editor();
                            History history = new History(editor);

                            history.backup();
                            editor.getTitle();

                            editor.setTitle("Test");
                            history.backup();

                            editor.setContent("Hello there, my name is Jarvis");
                            history.backup();
                        }
                    }


    - AI IMPROVEMENTS MADE:
        - EditorState:
            - final class and fields
            - Instance for timestamp

        - History:
            - Swapping Stack for Deque interface

            - OLD:
                public void undo() {
                    if (states.size() <= 0) {
                        return;
                    }

                    EditorState prevState = states.peek();
                    states.pop();
                    editor.restore(prevState);
                }

            - NEW:
                public void undo() {
                    if (states.isEmpty())
                        return;

                    editor.restore(states.pop());
                }

 */

public class Explanation {

}
