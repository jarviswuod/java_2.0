package _03_Design.Creational.Singleton;

import java.util.HashMap;
import java.util.Map;

/*

    NOTES:
    - Is a creational design pattern that ensures that a class only has one instance and provides a global access point to that instance
    - The single instance is commonly used for managing shared resources, configuration settings, or logging functionality within an application


    - We have 1 key player:
        - Singleton

*/

public class Notes {
    public static void main(String[] args) {

        AppSettings settings = AppSettings.getInstance();
        settings.set("app_name", "Design Patterns Mastery **");
        settings.set("app_creator", "Danny");

        System.out.println(settings.get("app_name"));
        System.out.println();

        Test.run();
    }
}

class Test {

    public static void run() {

        AppSettings settings = AppSettings.getInstance();
        System.out.println(settings.get("app_name"));
    }
}

class AppSettings {

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
