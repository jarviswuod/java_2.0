/*

    NOTES:
    
    LinkedList Methods
        - Adding -> add(), add(1, element), addFirst(), addLast()
        - Retriving -> get(), getFirst(), getLast()
        - Remove -> remove(), removeFirst(), removeLast(), clear()

 */

import java.util.LinkedList;

public class _12_LinkedListMethods {

    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guavas");
        System.out.println(fruits);

        // add(index, element) -> Adding an element at the specified position
        fruits.add(3, "Watermelon");
        System.out.println(fruits);

        // addFirst() -> Adding an element at the beginning or the LinkedList
        fruits.addFirst("Strawberry");
        System.out.println(fruits);

        // addLast() -> Adding an element at the end of the LinkedList
        fruits.addLast("Pawpaw");
        System.out.println(fruits);

        // getFirst() -> Getting the first element in the LinkedList
        System.out.println(fruits.getFirst());

        // getLast() -> Getting the last element in the LinkedList
        System.out.println(fruits.getLast());

        // get() -> Getting an element at a given position in the LinkedList
        System.out.println(fruits.get(2));

        // Getting all elements in a LinkedList
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // removeFirst() -> Removing the first element in the LinkedList
        System.out.println(fruits.removeFirst());

        // removeLast() -> Removing the last element in the LinkedList
        System.out.println(fruits.removeLast());

        // remove() -> Removing element of a given index or element name
        fruits.remove("banana");
        System.out.println(fruits);

        // clear() -> Remove everything in a LinkedList
        fruits.clear();
        System.out.println(fruits);
    }
}