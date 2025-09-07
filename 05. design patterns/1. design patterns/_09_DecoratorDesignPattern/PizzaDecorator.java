package _09_DecoratorDesignPattern;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String base() {
        return pizza.bake();
    }
}
