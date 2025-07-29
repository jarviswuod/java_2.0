/*
    NOTES:
         - Same method name
         - Same number of parameters
         - Same parameter types
         - Different behaviour
         - Difference classes (super and subclass)

 */

public class _27_MethodOveriding {

    public static void main(String[] args) {
        Animal animal1 = new Animal("Cow", 6, "Female");
        animal1.sound();
        animal1.animalType();

        Dog dog1 = new Dog("Asgad", 3, "Female");
        dog1.sound();
        dog1.animalType();
        dog1.offspring();

        Animal[] animals = { animal1, dog1 };

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}

class Animal {
    protected String name;
    protected int age;
    protected String gender;

    public Animal(String name, int age, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public void sound() {
        System.out.println("Communicate");
    }

    public void animalType() {
        System.out.println("Home raised");
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

}

class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void sound() {
        System.out.println("Barks");
    }

    public void offspring() {
        System.out.println("Gives birth to puppy");
    }

    @Override
    public void animalType() {
        System.out.println("Can be a pet or a security guard or both");
    }

    @Override
    public String toString() {
        return "Dog [name=" + super.name + ", age=" + super.age + ", gender=" + super.gender + "]";
    }
}