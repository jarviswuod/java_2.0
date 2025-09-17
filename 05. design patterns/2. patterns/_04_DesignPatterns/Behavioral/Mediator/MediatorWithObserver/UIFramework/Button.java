package _04_DesignPatterns.Behavioral.Mediator.MediatorWithObserver.UIFramework;

public class Button extends UIControl {

    private boolean isEnabled;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;

        notifyEventHandlers();
    }
}
