package _04_DesignPatterns.Creational.AbstractFactory.good;

public class UserSettingForm {

    public void render(UIComponentFactory uiComponentFactory) {

        uiComponentFactory.createButton().render();
        uiComponentFactory.createCheckBox().render();
    }
}
