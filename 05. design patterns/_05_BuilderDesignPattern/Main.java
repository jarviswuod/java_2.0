package _05_BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder()
                .mayonese(true)
                .onion(true)
                .extraCheese(true)
                .size("LARGE")
                .build();

        System.out.println(burger);

        Meal meal = new MealDirector(new VegMealBuilder()).preparedMeal();
        System.out.println(meal);

    }
}
