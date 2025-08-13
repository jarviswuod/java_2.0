import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class _04_ArrayListAction {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(22);
        list1.add(32);
        list1.add(52);
        list1.add(0, 52);

        System.out.println(list1);
        list1.remove(3);
        System.out.println(list1);

        System.out.println(list1.get(2));

        List<Integer> list2 = new ArrayList<>();
        list2.add(1012);
        list2.add(1022);
        list2.add(1032);
        list2.add(1052);

        list1.addAll(list2);

        List<Integer> list3 = new ArrayList<>(list1);
        System.out.println(list3);
        list2.set(3, 11111);
        System.out.println(list2);

        list1.clear();
        System.out.println(list1);

        Collections.sort(list3);
        System.out.println(list3);

        Collections.reverse(list3);
        System.out.println(list3);

        Collections.sort(list3, (a, b) -> a - b);
        System.out.println(list3);

        // Iterating
        System.out.println("Basic Loop");
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(list3.get(i) + ",   ");
        }
        System.out.println();

        System.out.println("For Each Loop");
        for (Integer element : list3) {
            System.out.print(element + ",  ");
        }
        System.out.println();

        System.out.println("Stream Loop");
        list3.stream().forEach(el -> System.out.print(el + ",  "));
        System.out.println();

        System.out.println("For each Loop");
        list3.forEach(el -> System.out.print(el + ",  "));
        System.out.println();

        System.out.println("Iterator for loop");
        for (Iterator<Integer> iter = list3.iterator(); iter.hasNext();) {
            System.out.print(iter.next() + ",   ");
        }
        System.out.println();

        System.out.println("While loop");
        Iterator<Integer> iter = list3.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ",   ");
        }
        System.out.println();
    }
}