import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _60_Sorting {

    public static void main(String[] args) {

        // Map<Integer, String> map = new HashMap<>();

        // map.put(1, "Jarvis");
        // map.put(2, "Name");
        // map.put(3, "Here");
        // map.put(4, "Wuod");

        List<Integer> list = new ArrayList<>();

        list.add(23);
        list.add(113);
        list.add(13);
        list.add(253);

        System.out.println(list);
        Collections.sort(list, (a, b) -> b - a);
        System.out.println(list);

    }
}