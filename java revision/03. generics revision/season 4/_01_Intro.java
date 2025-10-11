/*

    NOTES:
    - All I know about Generics:
    - Typecast:
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

public class _01_Intro {
    public static void main(String[] args) {

    }

    // public static void add(<T extends Number>) {

    // }
}

class DifferentClass<T extends Number> {
    public static void add() {

    }
}