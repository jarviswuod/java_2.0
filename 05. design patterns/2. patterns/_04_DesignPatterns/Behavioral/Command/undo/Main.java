package _04_DesignPatterns.Behavioral.Command.undo;

public class Main {

    public static void main(String[] args) {

        HtmlDocument htmlDoc = new HtmlDocument();
        History history = new History();

        htmlDoc.content = "Hello World";
        System.out.println(htmlDoc.content); // Hello World

        ItalicCommand italicCommand = new ItalicCommand(htmlDoc, history);
        italicCommand.execute();
        System.out.println(htmlDoc.content); // <i>Hello World</i>

        UndoCommand undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(htmlDoc.content); // Hello World

    }
}
