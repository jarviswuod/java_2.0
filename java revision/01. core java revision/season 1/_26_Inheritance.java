public class _26_Inheritance {

    public static void main(String[] args) {
        Animal animal1 = new Animal("Cow", 6, "Female");
        Animal animal2 = new Animal("Goat", 1, "Male");

        Dog dog1 = new Dog("Asgad", 3, "Female");
        dog1.sound();
        dog1.offspring();

        Animal[] animals = { animal1, animal2, dog1 };

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

    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

}

class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void offspring() {
        System.out.println("Gives birth to puppy");
    }

    @Override
    public String toString() {
        return "Dog [name=" + super.name + ", age=" + super.age + ", gender=" + super.gender + "]";
    }
}