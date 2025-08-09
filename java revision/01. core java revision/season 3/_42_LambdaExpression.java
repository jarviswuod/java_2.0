public class _42_LambdaExpression {

    public static void main(String[] args) {

        Animal animal = () -> {
            System.out.println("Animal name is defined here");
        };

        animal.animalName();
    }
}

@FunctionalInterface
interface Animal {
    void animalName();
}