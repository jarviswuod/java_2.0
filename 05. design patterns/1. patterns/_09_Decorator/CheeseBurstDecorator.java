package _09_Decorator;

public class CheeseBurstDecorator extends PizzaDecorator {

    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return pizza.bake() + addCheese();
    }

    private String addCheese() {
        return "Cheese";
    }
}
