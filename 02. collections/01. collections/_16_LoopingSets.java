/*

    NOTE:
    Iterating over an HashSet
        1. Enhanced forEach loop
        2. Basic loop with iterator
        3. Iterator with while loop
        4. Java 8 stream() + lamda example
        5. Java * forEach() + lamda example

 */

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class _16_LoopingSets {

    public static void main(String[] args) {

        Set<String> langs = new HashSet<>();

        System.out.println(langs.isEmpty());

        langs.add("C++");
        langs.add(".net");
        langs.add("nodeJs");
        langs.add("django");
        langs.add("react");

        // Enhanced forEach loop
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

        // Java 8 stream() + lamda example
        langs.stream().forEach(course -> System.out.println(course));
        System.out.println();

        // Java * forEach() + lamda example
        langs.forEach(course -> System.out.println(course));
        System.out.println();
    }
}
