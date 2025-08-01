// 4. Passing Current Object as Parameter

public class _33_5_ThisKeyword {
    public static void main(String[] args) {

    }
}

class EventHandler {
    private String name;

    public EventHandler(String name) {
        this.name = name;
        EventManager.register(this); // Pass current object to manager
    }

    public void handleEvent() {
        System.out.println(this.name + " handling event");
    }
}

class EventManager {
    static void register(EventHandler handler) {
        // Register the handler
    }
}