package _04_DesignPatterns.Behavioral.Momento.good;

import java.util.Date;

// Memento
public class EditorState {
    private String title;
    private String content;

    // State meta data
    private Date stateCreatedAt;

    public EditorState(String title, String content) {
        this.title = title;
        this.content = content;
        // this.stateCreatedAt = Date.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getStateCreatedAt() {
        return stateCreatedAt;
    }

    public String showName() {
        return stateCreatedAt + "/ " + title;
    }
}
