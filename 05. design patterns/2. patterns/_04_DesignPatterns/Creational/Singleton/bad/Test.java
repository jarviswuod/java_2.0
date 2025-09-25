package _04_DesignPatterns.Creational.Singleton.bad;

public class Test {

    public static void run() {

        AppSettings settings = new AppSettings();
        System.out.println(settings.get("app_name"));
    }
}
