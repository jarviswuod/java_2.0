/*

    NOTES:
         - Lambda is used to simplify code for functional interfaces (interfaces with one abstract method)
         - Lambda improves readability and reduces boilerplate

 */

public class _42_LamdaExpression {

    public static void main(String[] args) {

        Animal animal = (name) -> {
            System.out.println(name + " is the name of the animal");
        };

        animal.name("Akins");
    }
}

@FunctionalInterface
interface Animal {
    void name(String name);
}
