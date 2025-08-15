/*

    NOTES:

    ArrayList methods
     - isEmpty() -> Check if an ArrayList is empty
     - size() -> Find the size of an ArrayList
     - get(index) -> Retrieve elements at a given index
     - set(index, elementName) -> Modify elements at a given index
     - remove(index or elementName) -> Remove elements at a given index
     - removeAll(Collection c) -> Remove multiple elements in a list
     - clear() -> Remove everything in ArrayList
     - indexOf(elementName) -> Find the first occurrence of an element
     - lastIndexOf(elementName) -> Find the last occurrence of an element

 */

import java.util.ArrayList;
import java.util.List;

public class _06_ArrayListMethods {
    public static void main(String[] args) {

        List<String> programmingLangs = new ArrayList<>();

        // isEmpty()
        System.out.println(programmingLangs.isEmpty());

        programmingLangs.add("C");
        programmingLangs.add("Java");
        programmingLangs.add("Javascript");
        programmingLangs.add("Python");
        programmingLangs.add("C#");
        programmingLangs.add("C++");
        programmingLangs.add(".net");
        programmingLangs.add("nodeJs");
        programmingLangs.add("django");
        programmingLangs.add("react");

        System.out.println(programmingLangs);

        // indexOf()
        System.out.println(programmingLangs.indexOf("Python"));

        // lastIndexOf()
        System.out.println(programmingLangs.lastIndexOf("django"));

        // size()
        System.out.println(programmingLangs.size());

        // get()
        System.out.println(programmingLangs.get(3));
        System.out.println(programmingLangs.get(4));
        System.out.println(programmingLangs.get(2));

        // set()
        programmingLangs.set(4, "Typescript");
        System.out.println(programmingLangs.get(4));

        // remove()
        programmingLangs.remove(4);
        programmingLangs.remove("C#");
        System.out.println(programmingLangs);

        // removeAll()
        List<String> frameworks = new ArrayList<>();
        frameworks.add("nodeJs");
        frameworks.add("django");
        frameworks.add("react");
        System.out.println(frameworks);

        programmingLangs.removeAll(frameworks);
        System.out.println(programmingLangs);

        // clear()
        programmingLangs.clear();
        frameworks.clear();
        System.out.println(programmingLangs);
        System.out.println(frameworks);

    }
}
