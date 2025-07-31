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
