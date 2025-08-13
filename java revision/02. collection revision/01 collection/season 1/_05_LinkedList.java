/*

    - addFirst()
    - addLast()
    - removeFirst()
    - removeLast()
    - getFirst()
    - getLast()
    - contains()
    - containsAll(Collection c)
    - remove()
    - add()
    - isEmpty()
    - clear()
    - removeAll(Collection c)
    - addAll(Collection c)

 */

import java.util.LinkedList;

public class _05_LinkedList {
    public static void main(String[] args) {

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Jarvis");
        list1.add("Wuod");
        list1.add("Afghan");
        list1.add("Kefam");

        System.out.println(list1.isEmpty());
        System.out.println(list1);

        list1.add(3, "Meihem");
        System.out.println(list1);

        list1.addFirst("Nairobi");
        list1.addLast("Toyko");

        System.out.println(list1);

    }
}