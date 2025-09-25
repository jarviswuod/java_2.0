package _04_DesignPatterns.Creational.FactoryMethod.bad.solution2.MVCFramework;

import java.util.Map;

public class TwigViewEngine implements ViewEngine {

    @Override
    public String render(String fileName, Map<String, Object> data) {
        return "View rendered from " + fileName + " by Twig";
    }
}
