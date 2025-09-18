package _04_DesignPatterns.Behavioral.Command.undo;

public interface IUndoableCommand extends ICommand {

    void unexecute();
}
