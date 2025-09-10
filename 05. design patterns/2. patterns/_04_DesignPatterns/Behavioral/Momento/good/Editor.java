package _04_DesignPatterns.Behavioral.Momento.good;

// Originator
public class Editor {
    private String title;
    private String content;

    public EditorState createState() {
        return new EditorState(title, content);
    }

    public void restore(EditorState state) {
        title = state.getTitle();
        content = state.getContent();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
