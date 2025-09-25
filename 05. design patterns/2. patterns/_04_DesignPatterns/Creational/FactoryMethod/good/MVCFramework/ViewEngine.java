package _04_DesignPatterns.Creational.FactoryMethod.good.MVCFramework;

import java.util.Map;

public interface ViewEngine {

    public String render(String fileName, Map<String, Object> data);
}
