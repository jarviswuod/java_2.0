package _04_DesignPatterns.Behavioral.Mediator.MediatorWithObserver.UIFramework;

import java.util.ArrayList;
import java.util.List;

public class UIControl {

    private List<EventHandler> eventHandlers = new ArrayList<>();

    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public void notifyEventHandlers() {
        for (EventHandler handler : eventHandlers)
            handler.handle();
    }
}
