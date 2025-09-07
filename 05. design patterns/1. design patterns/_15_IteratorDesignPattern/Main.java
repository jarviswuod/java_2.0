package _15_IteratorDesignPattern;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        OurGenericList<Integer> list = new OurGenericList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        System.out.println();
        System.out.println();

        // same way of doing it all is by
        for (Object value : list) {
            System.out.println(value);
        }
    }
}