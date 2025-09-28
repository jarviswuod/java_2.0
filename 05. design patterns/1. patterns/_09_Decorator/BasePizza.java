package _09_Decorator;

public class BasePizza implements Pizza {

    @Override
    public String bake() {
        return "Base Pizza";
    }
}
