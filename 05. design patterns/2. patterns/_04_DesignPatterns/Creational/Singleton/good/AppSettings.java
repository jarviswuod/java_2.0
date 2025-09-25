package _04_DesignPatterns.Creational.Singleton.good;

import java.util.Map;
import java.util.HashMap;

public class AppSettings {

    private static AppSettings instance;
    private Map<String, Object> settings = new HashMap<>();

    private AppSettings() {
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }

        return instance;
    }

    public Object get(String key) {
        if (!settings.containsKey(key))
            return null;
        return settings.get(key);
    }

    public void set(String key, Object value) {
        settings.put(key, value);
    }
}
