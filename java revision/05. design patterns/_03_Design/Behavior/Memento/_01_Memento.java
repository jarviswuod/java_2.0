package _03_Design.Behavior.Memento;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;

/* 

    NOTES:
    - Is a behavioral design pattern that allows you to capture and export the internal state of an object without exposing the encapsulation
    - Key players:
        - Originator
        - Memento
        - Caretaker

    - Text Editor

*/

public class _01_Memento {
    public static void main(String[] args) {

        _Editor editor = new _Editor("", "");
        _History history = new _History(editor);
        history.save();

        editor.setTitle("Jarvis blog");
        editor.setDescription("descriptio");
        history.save();

        editor.setTitle("Jarvis");
        history.save();
        System.out.println(editor);

        editor.setDescription("desc");
        history.save();

        editor.setDescription("provided");
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

class _Editor {

    private String title;
    private String description;

    public _Editor(String title, String description) {
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

    public _EditorState save() {
        return new _EditorState(title, description);
    }

    public void undo(_EditorState editorState) {
        title = editorState.getTitle();
        description = editorState.getDescription();
    }

    @Override
    public String toString() {
        return "_Editor [title=" + title + ", description=" + description + "]";
    }
}

class _EditorState {
    private String title;
    private String description;
    private Instant timeStamp;

    public _EditorState(String title, String description) {
        this.title = title;
        this.description = description;
        timeStamp = Instant.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "_EditorState [title=" + title + ", description=" + description + ", timeStamp=" + timeStamp + "]";
    }
}

class _History {

    private _Editor editor;

    Deque<_EditorState> list = new ArrayDeque<>();

    public _History(_Editor editor) {
        this.editor = editor;
    }

    public void save() {
        list.push(editor.save());
    }

    public void undo() {
        if (!list.isEmpty())
            editor.undo(list.pop());
    }
}
