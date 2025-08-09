public class _40_FunctionalInterface {
    public static void main(String[] args) {
        Animal animal = new Animal() {

            @Override
            public void animalName() {
                System.out.println("Animal name is defined here");
            }
        };
        animal.animalName();
    }
}

@FunctionalInterface
interface Animal {
    void animalName();
}