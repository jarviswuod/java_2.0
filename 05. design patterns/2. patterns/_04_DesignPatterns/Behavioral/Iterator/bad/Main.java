package _04_DesignPatterns.Behavioral.Iterator.bad;

public class Main {
    public static void main(String[] args) {

        ShoppingList shoppingList = new ShoppingList();

        shoppingList.push("Milk");
        shoppingList.push("honey");
        shoppingList.push("Tea");
        shoppingList.push("Steak");
        shoppingList.push("Bread");

        System.out.println("Shopping List: " + shoppingList.getList());

        for (int i = 0; i < shoppingList.getList().size(); i++) {
            System.out.println(shoppingList.getList().get(i));
        }
    }
}
