package _04_DesignPatterns.Creational.Singleton.good;

public class Test {

    public static void run() {

        AppSettings settings = AppSettings.getInstance();
        System.out.println(settings.get("app_name"));
    }
}
