package _04_DesignPatterns.Creational.FactoryMethod.good.MVCFramework;

import java.util.Map;

public class BladeViewEngine implements ViewEngine {

    @Override
    public String render(String fileName, Map<String, Object> data) {
        return "View rendered from " + fileName + " by Blade";
    }
}
