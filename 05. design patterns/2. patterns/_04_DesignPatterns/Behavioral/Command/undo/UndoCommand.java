package _04_DesignPatterns.Behavioral.Command.undo;

public class UndoCommand implements Command {

    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (history.size() > 0) {
            UndoableCommand lastCommand = history.pop();
            lastCommand.unexecute();
        }
    }
}
