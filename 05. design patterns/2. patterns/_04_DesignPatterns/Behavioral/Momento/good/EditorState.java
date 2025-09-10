package _04_DesignPatterns.Behavioral.Momento.good;

import java.time.Instant;

// Memento
public final class EditorState {
    private final String title;
    private final String content;
    private final Instant createdAt;

    public EditorState(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = Instant.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return createdAt + " / " + title;
    }
}
