package _04_DesignPatterns.Behavioral.Mediator.MediatorWithObserver.UIFramework;

public class ListBox extends UIControl {

    private String selection = "";

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;

        notifyEventHandlers();
    }
}
