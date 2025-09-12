package _04_DesignPatterns.Behavioral.command.undo;

public class HtmlDocument {

    public String content;

    public void makeItalic() {
        content = "<i>" + content + "</i>";
    }
}
