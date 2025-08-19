/*

    NOTES:
    - Collections.sort(list, (a, b)-> a-b )
    - Collections.sort()
    - Collections.reverse()

 */

import java.util.ArrayList;
import java.util.Collections;

public class _60_Sorting {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(list, (a, b) -> a - b);

    }
}