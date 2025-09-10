package _04_DesignPatterns.Behavioral.Momento.good;

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

        editor.setContent("The life of a dev: my moments");
        history.backup();

        System.out.println("Title: " + editor.getTitle());
        System.out.println("Content: " + editor.getContent());

        history.undo();
        System.out.println("Title: " + editor.getTitle());
        System.out.println("Content: " + editor.getContent());

        history.showHistory();

        history.undo();
        System.out.println("Title: " + editor.getTitle());
        System.out.println("Content: " + editor.getContent());

        history.undo();
        System.out.println("Title: " + editor.getTitle());
        System.out.println("Content: " + editor.getContent());
    }
}
