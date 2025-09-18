package _04_DesignPatterns.Behavioral.Command.undo;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {

    private Deque<IUndoableCommand> commands = new ArrayDeque<>();

    public void push(IUndoableCommand command) {
        commands.push(command);
    }

    public IUndoableCommand pop() {
        IUndoableCommand last = commands.pop();
        return last;
    }

    public int size() {
        return commands.size();
    }
}
