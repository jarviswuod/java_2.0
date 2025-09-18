package _04_DesignPatterns.Behavioral.Command.undo;

public class ItalicCommand implements IUndoableCommand {

    private HtmlDocument document;
    private String prevContent = "";
    private History history;

    public ItalicCommand(HtmlDocument document, History history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        prevContent = document.content;
        document.makeItalic();
        history.push(this);
    }

    @Override
    public void unexecute() {
        document.content = prevContent;
    }
}
