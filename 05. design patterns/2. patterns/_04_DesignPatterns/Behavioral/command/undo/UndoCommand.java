package _04_DesignPatterns.Behavioral.command.undo;

public class UndoCommand implements ICommand {

    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (history.size() > 0) {
            IUndoableCommand lastCommand = history.pop();
            lastCommand.unexecute();
        }
    }

}
