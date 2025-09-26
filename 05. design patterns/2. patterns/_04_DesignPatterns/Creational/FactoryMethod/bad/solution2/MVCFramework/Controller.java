package _04_DesignPatterns.Creational.FactoryMethod.bad.solution2.MVCFramework;

import java.util.Map;

public class Controller {

    public void render(String fileName, Map<String, Object> data, ViewEngine viewEngine) {

        String html = viewEngine.render(fileName, data);
        System.out.println(html);
    }
}
