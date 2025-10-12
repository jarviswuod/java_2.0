/*

    NOTES:
    - All I know about Generics:
    - Type parameter:
        - 

    - Wildcards
        - Lower wildcards <? extends Type>
        - Upper wildcards <? super Type>

    - Keywords:
        - extends
        - super

    - invariance:
        - Only picks the excact value needed by the method
        - Generics is invariance by default

    - contravariance:
        - Works with values greater than the one needed

    - covariance:
        - When a value is needed you can provide a more specific value and still works
        - By default java is Covaraint

    - getput PESC method

 */

import java.util.List;

public class _01_Intro {
    public static void main(String[] args) {

        List<Integer> intList = List.of(2, 4, 7, 8, 9, 1);
        add(intList);

    }

    public static void add(List<? extends Number> list2) {

        double sum = 0;
        for (Number number : list2) {
            sum += number.doubleValue();
        }

        System.out.println(sum);
    }
}

class DifferentClass<T extends Number> {
    public static void add() {

    }
}