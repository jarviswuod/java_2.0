package _04_DesignPatterns.Creational.Singleton.bad;

public class Main {
    public static void main(String[] args) {

        AppSettings settings = new AppSettings();
        settings.set("app_name", "Design Patterns Mastery");
        settings.set("app_creator", "Danny");

        System.out.println(settings.get("app_name"));
        System.out.println();

        Test.run();
    }
}
