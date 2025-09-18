package _04_DesignPatterns.Behavioral.Command.undo;

public class HtmlDocument {

    public String content;

    public void makeItalic() {
        content = "<i>" + content + "</i>";
    }
}
