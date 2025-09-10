package _04_DesignPatterns.Behavioral.Momento.good;

import java.util.ArrayDeque;
import java.util.Deque;

// Caretaker
public class History {

    private final Deque<EditorState> states = new ArrayDeque<>();
    private final Editor editor;

    public History(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        states.push(editor.createState());
    }

    public void undo() {
        if (states.isEmpty())
            return;

        editor.restore(states.pop());
    }

    public void showHistory() {
        System.out.println("History: Here is the list of Mementos");

        for (EditorState editorState : states) {
            System.out.println(editorState.toString());
        }
    }
}
