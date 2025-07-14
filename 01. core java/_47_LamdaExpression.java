/*
 * With lamda expression we can simplify anonymous classes
 */

//  /////////////////////////////////////////////////////////////////////////////////////
//  EXAMPLE 1
//  /////////////////////////////////////////////////////////////////////////////////////
public class _47_LamdaExpression {
    public static void main(String[] args) {

        A obj = () -> System.out.println("In show");
        obj.show();
    }
}

@FunctionalInterface
interface A {
    void show();
}

// /////////////////////////////////////////////////////////////////////////////////////
// EXAMPLE 2
// /////////////////////////////////////////////////////////////////////////////////////
class _42_LamdaExpression_ {
    public static void main(String[] args) {

        // WITHOUT THE LAMDA EXPRESSION
        B obj1 = new B() {

            @Override
            public int add(int i, int j) {
                return i + j;
            }
        };
        System.out.println(obj1.add(18, 23));

        // WITH LAMDA
        B obj2 = (int i, int j) -> i + j;
        System.out.println(obj2.add(21, 5));

    }
}

@FunctionalInterface
interface B {
    int add(int i, int j);
}