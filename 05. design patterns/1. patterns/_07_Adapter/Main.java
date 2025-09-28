package _07_Adapter;

public class Main {
    public static void main(String[] args) {

        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItems(new FoodItem());
        swiggyStore.addItems(new FoodItem());

        swiggyStore.addItems(new GroceryItemAdapter(new GroceryProduct()));
    }
}
