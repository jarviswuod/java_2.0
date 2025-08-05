import java.util.HashSet;
import java.util.Set;

public class _58_Set {
    public static void main(String[] args) {

        Set set = new HashSet<>();
        set.add(12);
        set.add(22);
        set.add(32);
        set.add(48);
        set.add(88);

        System.out.println(set);

        set.remove(88);
        System.out.println(set);
    }
}
