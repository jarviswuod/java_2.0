package _04_DesignPatterns.Behavioral.Command.undo;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {

    private Deque<UndoableCommand> commands = new ArrayDeque<>();

    public void push(UndoableCommand command) {
        commands.push(command);
    }

    public UndoableCommand pop() {
        if (commands.isEmpty()) {
            return null;
        }
        return commands.pop();
    }

    public int size() {
        return commands.size();
    }
}
