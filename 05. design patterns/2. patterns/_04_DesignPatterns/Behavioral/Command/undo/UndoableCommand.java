package _04_DesignPatterns.Behavioral.Command.undo;

public interface UndoableCommand extends Command {

    void unexecute();
}
