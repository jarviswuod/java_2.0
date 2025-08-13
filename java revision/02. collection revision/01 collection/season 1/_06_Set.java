/*

    Set
      - Insertion order not followed
      - TreeSet is sorted

      - remove(elementName)
      - removeAll()
      - isEmpty()
      - size()
      - add(elementName)
      - clear()
      - addAll()
      - containsAll()
      - contains()

 */

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class _06_Set {
    public static void main(String[] args) {

        Set<String> list1 = new HashSet<>();
        list1.add("Jarvis");
        list1.add("Wuod");
        list1.add("Afghan");
        list1.add("Kefam");
        list1.remove("Kefam");

        System.out.println(list1);

        Set<String> list2 = new TreeSet<>();
        list2.add("Jarvis");
        list2.add("Wuod");
        list2.add("Afghan");
        list2.add("Kefam");
        list2.removeAll(list1);

        System.out.println(list2.containsAll(list1));
        System.out.println(list2);

        System.out.println(list1);

        System.out.println("---------- LOOPING ----------");

        System.out.println("FOR EACH");
        for (String string : list2) {
            System.out.print(string + ", ");
        }
        System.out.println();

        System.out.println("FOR WITH ITERATOR");
        for (Iterator<String> iter = list1.iterator(); iter.hasNext();) {
            System.out.print(iter.next() + ",  ");
        }
        System.out.println();

        System.out.println("While loop");
        Iterator<String> iter = list1.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ",  ");
        }
        System.out.println();

        System.out.println("ForEach loop");
        list1.forEach(el -> System.out.print(el + ", "));
        System.out.println();

        System.out.println("Stream ForEach loop");
        list1.stream().forEach(el -> System.out.print(el + ", "));
        System.out.println();

    }
}