package _04_DesignPatterns.Creational.AbstractFactory.good;

public class Main {
    public static void main(String[] args) {

        OperatingSystemType os = OperatingSystemType.Mac;
        UIComponentFactory uiComponentFactory;

        if (os == OperatingSystemType.Mac) {
            uiComponentFactory = new MacUIComponentFactory();
        } else if (os == OperatingSystemType.Windows) {
            uiComponentFactory = new WindowsUIComponentFactory();
        } else {
            uiComponentFactory = new WindowsUIComponentFactory();

            System.out.println("Unsupported OS");
        }

        new UserSettingForm().render(uiComponentFactory);
    }
}
