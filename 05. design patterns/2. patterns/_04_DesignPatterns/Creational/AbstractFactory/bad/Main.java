package _04_DesignPatterns.Creational.AbstractFactory.bad;

public class Main {
    public static void main(String[] args) {

        // OperatingSystemType os = OperatingSystemType.Windows;
        OperatingSystemType os = OperatingSystemType.Mac;
        UserSettingForm usersSettingForm = new UserSettingForm();
        usersSettingForm.render(os);
    }
}
