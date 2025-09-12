package _04_DesignPatterns.Behavioral.command.good;

public class RemoteControl {

    private ICommand command;

    public RemoteControl(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

}
