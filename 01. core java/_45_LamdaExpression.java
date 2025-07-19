/*
    With lamda expression we can simplify anonymous classes

 */

//  /////////////////////////////////////////////////////////////////////////////////////
//  EXAMPLE 2
//  /////////////////////////////////////////////////////////////////////////////////////
public class _45_LamdaExpression {
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
// EXAMPLE 1
// /////////////////////////////////////////////////////////////////////////////////////
class _45_LamdaExpression_ {
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
        B obj2 = (i, j) -> i + j;
        System.out.println(obj2.add(21, 5));

    }
}

@FunctionalInterface
interface B {
    int add(int i, int j);
}