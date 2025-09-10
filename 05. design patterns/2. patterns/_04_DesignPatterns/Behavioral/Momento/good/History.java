package _04_DesignPatterns.Behavioral.Momento.good;

import java.util.Stack;

// Caretaker
public class History {

    private Stack<EditorState> states = new Stack<>();
    private Editor editor;

    public History(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        states.push(editor.createState());
    }

    public void undo() {
        if (states.size() <= 0) {
            return;
        }

        EditorState prevState = states.peek();
        states.pop();
        editor.restore(prevState);
    }

    public void showHistory() {
        System.out.println("History: Here is the list of Mementos");

        for (EditorState editorState : states) {
            System.out.println(editorState.showName());
        }
    }
}
