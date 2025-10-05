/*

    NOTES;
    - A simplified way of handling anynomous classes with arrow fucntion in between
    - Example:
        ClassName cl = ((name, age) -> System.out.println(name + " " + age));

 */

public class _42_LamdaExpression {
    public static void main(String[] args) {

        ClassName cl = (name, age) -> System.out.println(name + " " + age);
        cl.askName("Alice", 25);
    }
}

@FunctionalInterface
interface ClassName {
    void askName(String name, int age);
}