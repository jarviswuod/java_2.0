/*

    NOTE:
    Iterating over an LinkedList
        1. Basic for loop
        2. Enhanced for loop
        3. Basic loop with iterator
        4. Iterator with while loop
        5. Java 8 stream + lamda example
        6. Java 8 forEach + lamda example

 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _13_LinkedListIteration {
    public static void main(String[] args) {

        List<String> langs = new LinkedList<>();

        System.out.println(langs.isEmpty());

        langs.add("C++");
        langs.add(".net");
        langs.add("nodeJs");
        langs.add("django");
        langs.add("react");

        // Basic for loop
        for (int i = 0; i < langs.size(); i++) {
            System.out.println(langs.get(i));
        }
        System.out.println();

        // Enhanced for loop
        for (String course : langs) {
            System.out.println(course);
        }
        System.out.println();

        // Basic loop with iterator
        for (Iterator<String> iterator = langs.iterator(); iterator.hasNext();) {
            String course = (String) iterator.next();
            System.out.println(course);
        }
        System.out.println();

        // Iterator with while loop
        Iterator<String> iterator = langs.iterator();
        while (iterator.hasNext()) {
            String course = (String) iterator.next();
            System.out.println(course);
        }
        System.out.println();

        // Java 8 stream + lamda example
        langs.stream().forEach(course -> System.out.println(course));
        System.out.println();

        // Java * forEach + lamda example
        langs.forEach(course -> System.out.println(course));
        System.out.println();
    }
}
