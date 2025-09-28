package _05_Builder;

public class Main {
    public static void main(String[] args) {

        Burger burger = new Burger.BurgerBuilder()
                .mayonese(true)
                .onion(true)
                .extraCheese(true)
                .size("LARGE")
                .build();

        System.out.println(burger);

        System.out.println();

        Meal meal = new MealDirector(new VegMealBuilder()).preparedMeal();
        System.out.println(meal);
    }
}
