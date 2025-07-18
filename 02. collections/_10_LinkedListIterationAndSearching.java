import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _10_LinkedListIterationAndSearching {
    public static void main(String[] args) {

        List<String> langs = new LinkedList<>();

        System.out.println(langs.isEmpty());

        langs.add("C++");
        langs.add(".net");
        langs.add("nodeJs");
        langs.add("django");
        langs.add("react");

        // Find the first occurrence of an element in the LinkedList
        System.out.println(langs.indexOf("Python"));

        // Find the last occurrence of an element in the LinkedList
        System.out.println(langs.lastIndexOf("django"));

        // LinkedList iteration methods
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
        for (Iterator iterator = langs.iterator(); iterator.hasNext();) {
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
