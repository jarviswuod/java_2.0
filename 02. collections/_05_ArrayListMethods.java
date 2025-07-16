import java.util.ArrayList;
import java.util.List;

public class _05_ArrayListMethods {
    public static void main(String[] args) {

        List<String> programmingLangs = new ArrayList<>();

        // isEmpty() -> Check if an ArrayList is empty
        System.out.println(programmingLangs.isEmpty());

        programmingLangs.add("C");
        programmingLangs.add("Java");
        programmingLangs.add("Javascript");
        programmingLangs.add("Python");
        programmingLangs.add("C++");
        programmingLangs.add(".net");
        programmingLangs.add("nodeJs");
        programmingLangs.add("django");
        programmingLangs.add("react");

        System.out.println(programmingLangs);

        // .size() -> FInd the size of an ArrayList
        System.out.println(programmingLangs.size());

        // .get() -> Retrive elements at a given index
        System.out.println(programmingLangs.get(3));
        System.out.println(programmingLangs.get(4));
        System.out.println(programmingLangs.get(2));

        // .set() -> Modify elements at a given index
        programmingLangs.set(4, "Typescript");
        System.out.println(programmingLangs.get(4));

        // .remove() -> Remove elements at a given index
        programmingLangs.remove(4);
        programmingLangs.remove("C++");
        System.out.println(programmingLangs);

        // .removeAll() -> Remove multiple elements in a list
        List<String> frameworks = new ArrayList<>();
        frameworks.add("nodeJs");
        frameworks.add("django");
        frameworks.add("react");
        System.out.println(frameworks);

        programmingLangs.removeAll(frameworks);
        System.out.println(programmingLangs);

        // .clear() -> Remove everything in ArrayList
        programmingLangs.clear();
        frameworks.clear();
        System.out.println(programmingLangs);
        System.out.println(frameworks);

    }
}
