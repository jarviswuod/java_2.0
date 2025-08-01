/*

    NOTES:
       - Lambda expressions
           - Used to simplify code for functional interfaces (interfaces with one abstract method)
           - Replaces anonymous class implementations with concise syntax
           - Improves readability and reduces boilerplate
           
           
           EXAMPLE 2:
           - Interface A has one method `show()` → lambda: () -> System.out.println("In show")
           
           EXAMPLE 1:
           - Interface B has one method → can be replaced with a lambda: (i, j) -> i + j

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