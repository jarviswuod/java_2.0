package _09_DecoratorDesignPattern;

public class BasePizza implements Pizza {

    @Override
    public String bake() {
        return "Base Pizza";
    }

}
