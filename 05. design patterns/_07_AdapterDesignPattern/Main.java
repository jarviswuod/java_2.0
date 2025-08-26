package _07_AdapterDesignPattern;

public class Main {
    public static void main(String[] args) {
        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItems(new FoodItem());
        swiggyStore.addItems(new FoodItem());

        swiggyStore.addItems(new GroceryItemAdapter(new GroceryProduct()));

    }
}
