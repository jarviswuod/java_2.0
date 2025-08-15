/*


    NOTES:
    - LinkedList
         - The LinkedList class implements Queue and Deque interfaces
         - It can be used as a Queue, Deque or Stack coz ^^^
         - Java LinkedList class can contain duplicate elements
         - Java LinkedList class maintains insertion order
         - Java LinkedList is not thread-safe. You must explicity synchronize it in a multi-threaded environment.

 */

import java.util.LinkedList;
import java.util.List;

public class _10_LinkedListIntro {

    public static void main(String[] args) {

        // Creating a LinkedList object
        List<String> fruits = new LinkedList<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guavas");
        System.out.println(fruits);

    }
}