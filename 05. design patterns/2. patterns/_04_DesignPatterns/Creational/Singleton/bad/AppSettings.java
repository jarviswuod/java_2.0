package _04_DesignPatterns.Creational.Singleton.bad;

import java.util.Map;
import java.util.HashMap;

public class AppSettings {
    private Map<String, Object> settings = new HashMap<>();

    public Object get(String key) {
        if (!settings.containsKey(key))
            return null;
        return settings.get(key);
    }

    public void set(String key, Object value) {
        settings.put(key, value);
    }
}
