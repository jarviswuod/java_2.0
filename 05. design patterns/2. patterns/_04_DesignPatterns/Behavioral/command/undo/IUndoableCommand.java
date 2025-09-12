package _04_DesignPatterns.Behavioral.command.undo;

public interface IUndoableCommand extends ICommand {

    void unexecute();
}
