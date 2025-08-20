/*

    NOTE:
    - Iterating over an ArrayList
        1. Basic for loop
        2. Enhanced for loop
        3. Basic loop with iterator
        4. Iterator with while loop
        5. Java 8 stream + lamda example
        6. Java 8 forEach + lamda example

 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _07_ArrayListIteration {
    public static void main(String[] args) {

        List<String> courses = Arrays.asList("C", "C++", "Java", "Spring", "C#");

        // Basic for loop
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }
        System.out.println();

        // Enhanced for loop
        for (String course : courses) {
            System.out.println(course);
        }
        System.out.println();

        // Basic loop with iterator
        for (Iterator<String> iterator = courses.iterator(); iterator.hasNext();) {
            String course = (String) iterator.next();
            System.out.println(course);
        }
        System.out.println();

        // Iterator with while loop
        Iterator<String> iterator = courses.iterator();
        while (iterator.hasNext()) {
            String course = (String) iterator.next();
            System.out.println(course);
        }
        System.out.println();

        // Java 8 stream + lamda example
        courses.stream().forEach(course -> System.out.println(course));
        System.out.println();

        // Java 8 forEach + lamda example
        courses.forEach(course -> System.out.println(course));
        System.out.println();
    }
}
