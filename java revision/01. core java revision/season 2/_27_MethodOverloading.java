public class _27_MethodOverloading {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();

        animal.sayName();
        cat.sayName();

        cat.catOnly();

    }
}

class Animal {
    private String breed;
    private int age;

    public void show() {
        System.out.println("Animal here");
    }

    public void sayName() {
        System.out.println("My name");
    }

    @Override
    public String toString() {
        return "Animal [breed=" + breed + ", age=" + age + "]";
    }
}

class Cat extends Animal {
    public void sayName() {
        System.out.println("Cat by default");
    }

    public void catOnly() {
        System.out.println("Cat Only");
    }
}