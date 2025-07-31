import java.util.Set;
import java.util.TreeSet;

public class _58_Sets {

    public static void main(String[] args) {

        Set<Integer> set1 = new TreeSet<>();

        set1.add(12);
        set1.add(24);
        set1.add(36);
        set1.add(124);
        set1.add(42);
        set1.add(102);
        set1.add(82);

        System.out.println(set1);
        set1.remove(12);
        set1.remove(82);
        set1.remove(124);

        System.out.println(set1);
    }
}
