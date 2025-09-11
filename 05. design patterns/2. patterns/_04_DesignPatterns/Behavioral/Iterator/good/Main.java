package _04_DesignPatterns.Behavioral.Iterator.good;

public class Main {
    public static void main(String[] args) {

        ShoppingList shoppingList = new ShoppingList();

        shoppingList.push("Milk");
        shoppingList.push("honey");
        shoppingList.push("Tea");
        shoppingList.push("Steak");
        shoppingList.push("Bread");

        // System.out.println("Shopping List: " + shoppingList.getList());

        IIterator<String> iterator = shoppingList.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.current());
            iterator.next();
        }
    }
}