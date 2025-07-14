// 1. Basic Usage - Accessing Parent Class Members

public class _31_SuperKeywordExample_1 {
    public static void main(String[] args) {
        Animal animal = new Animal("Salmonela", 12);
        System.out.println(animal);

        Dog dog = new Dog(null, 23);
        System.out.println(dog);
        dog.makeSound();
        dog.sleep();

    }
}

class Animal {
    protected String species;
    protected int age;

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    protected void sleep() {
        System.out.println("Animal is sleeping");
    }

    @Override
    public String toString() {
        return "Animal [species=" + species + ", age=" + age + "]";
    }

}

class Dog extends Animal {
    private String breed;

    public Dog(String breed, int age) {
        super("Canine", age); // Call parent constructor
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        super.makeSound(); // Call parent method first
        System.out.println("Woof! Woof!");
    }

    public void displayInfo() {
        System.out.println("Species: " + super.species); // Access parent field
        System.out.println("Breed: " + this.breed);
        System.out.println("Age: " + super.age);
    }

    public void rest() {
        super.sleep(); // Call protected parent method
    }
}