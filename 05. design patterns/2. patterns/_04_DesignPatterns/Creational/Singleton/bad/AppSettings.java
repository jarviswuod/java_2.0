package _04_DesignPatterns.Creational.Singleton.bad;

import java.util.Map;
import java.util.HashMap;

public class AppSettings {
    private Map<String, String> settings = new HashMap<>();

    public String get(String key) {
        if (!settings.containsKey(key))
            return null;
        return settings.get(key);
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }
}
