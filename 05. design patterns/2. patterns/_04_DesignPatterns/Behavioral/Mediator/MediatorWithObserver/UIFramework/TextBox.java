package _04_DesignPatterns.Behavioral.Mediator.MediatorWithObserver.UIFramework;

public class TextBox extends UIControl {

    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;

        notifyEventHandlers();
    }
}
