package _04_DesignPatterns.Behavioral.Mediator.good;

public class UIControl {

    protected DialogBox owner;

    public UIControl(DialogBox owner) {
        this.owner = owner;
    }
}
