package _05_Builder;

public class MealDirector {

    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal preparedMeal() {
        mealBuilder.addBread();
        mealBuilder.addBriyani();
        mealBuilder.addColdDrink();
        mealBuilder.addCurry();
        return mealBuilder.build();
    }
}
