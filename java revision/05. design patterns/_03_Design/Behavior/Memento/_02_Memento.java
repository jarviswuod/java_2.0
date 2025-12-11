package _03_Design.Behavior.Memento;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;

/*

    NOTES:
    - Is a behavioral pattern that captures and externalizes the internal state of an object without affecting it's encapsulation
    - Key players:
        - Originator
        - Memento
        - Caretaker

    - Example:
        - Online text editor

*/

public class _02_Memento {
    public static void main(String[] args) {

        _02_Editor editor = new _02_Editor("", "");
        _02_History history = new _02_History(editor);
        history.save();

        editor.setTitle("title");
        editor.setDescription("description too");
        history.save();

        editor.setDescription("nice description");
        history.save();

        System.out.println(editor);
        System.out.println();
        history.undo();
        System.out.println(editor);

        history.undo();
        System.out.println(editor);

        history.undo();
        System.out.println(editor);

    }
}

class _02_Editor {

    private String title;
    private String description;

    public _02_Editor(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public _02_EditorState save() {
        return new _02_EditorState(title, description);
    }

    public void undo(_02_EditorState state) {
        title = state.getTitle();
        description = state.getDescription();
    }

    @Override
    public String toString() {
        return "_02_Editor [title=" + title + ", description=" + description + "]";
    }
}

class _02_EditorState {

    private final String title;
    private final String description;
    private Instant instant;

    public _02_EditorState(String title, String description) {
        this.title = title;
        this.description = description;
        instant = Instant.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "_02_EditorState [title=" + title + ", description=" + description + ", instant=" + instant + "]";
    }
}

class _02_History {

    private _02_Editor editor;
    private Deque<_02_EditorState> states = new ArrayDeque<>();

    public _02_History(_02_Editor editor) {
        this.editor = editor;
    }

    public void save() {
        states.push(editor.save());
    }

    public void undo() {
        if (!states.isEmpty()) {
            editor.undo(states.pop());
        }
    }
}
