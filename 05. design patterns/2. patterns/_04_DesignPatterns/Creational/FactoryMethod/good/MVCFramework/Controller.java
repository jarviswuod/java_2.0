package _04_DesignPatterns.Creational.FactoryMethod.good.MVCFramework;

import java.util.Map;

public class Controller {

    public void render(String fileName, Map<String, Object> data) {

        ViewEngine viewEngine = CreateViewEngine();
        String html = viewEngine.render(fileName, data);
        System.out.println(html);
    }

    protected ViewEngine CreateViewEngine() {
        return new BladeViewEngine();
    }
}
