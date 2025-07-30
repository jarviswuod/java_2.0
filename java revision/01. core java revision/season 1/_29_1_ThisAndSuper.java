/*

    NOTES:
     - this usecases
          1. Basic Usage - Resolving Name Conflicts
          2. Constructor Chaining with this()
          3. Method Chaining (Fluent Interface)
          4. Passing Current Object as Parameter

     - super usecases
          1. Basic Usage - Accessing Parent Class Members
          2. Constructor Chaining with super()
          3. Method Overriding and Super Calls
          4. Resolving Same Interface Method Names Conflicts

    IN ACTION:

    - This USECASES:
        - Resolving Name Conflicts
            - this.name = name; // Without 'this', we'd assign parameter to itself
        - Constructor Chaining with this()
            - this(1.0, 1.0); // Calls the two-parameter constructor
            - this(side, side); // Calls the two-parameter constructor
        - Method Chaining (Fluent Interface)
            - public StringBuilder append(String text) {
                    this.content += text;
                    return this; // Returns current object for chaining
                }
        - Passing Current Object as Parameter
            - EventManager.register(this); // Pass current object to manager
        - Inside Inner Classes to Refer to Outer Class
            - Dashboard.this.status = "ON";
        - Synchronize on the Current Object (Multithreading)
            - synchronized (this) { // thread-safe code for this object }
        - Method Reference to Current Object
            - public void doPrint() {
                    List<String> names = List.of("Alice", "Bob");
                    names.forEach(this::print); // ← method reference to this object's print()
                    same as -> names.forEach(name -> this.print(name));
                }


    - Super USECASES:
        - Basic Usage - Accessing Parent Class Members
           - super("Canine", age); // Call parent constructor
           - super.makeSound(); // Call parent method first
           - System.out.println("Species: " + super.species); // Access parent field
           - super.sleep(); // Call protected parent method
        - Constructor Chaining with super()
           - super(make, model, year); // Must be first statement
           - super(make, model); // Calls parent's two-parameter constructor
        - Method Overriding and Super Calls
           - super.calculateArea(); // Call parent method
           - super.display(); // Call parent display
        - Resolving Same Interface Method Names Conflicts
           - Drawable.super.draw(); // Call specific interface default method
           - Colorable.super.draw(); // Call other interface default method

 */

public class _29_1_ThisAndSuper {

    public static void main(String[] args) {
        Animal animal1 = new Animal("Cow", "Female");
        animal1.sound();
        animal1.animalType();

        Dog dog1 = new Dog("Chiwawa");
        dog1.sound();
        dog1.animalType();

        Animal[] animals = { animal1, dog1 };

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}

class Animal {
    protected String type;
    protected int age;
    protected String gender;

    public Animal(String type, int age, String gender) {
        this.age = age;
        this.type = type;
        this.gender = gender;
    }

    public Animal(String type, String gender) {
        this(type, 1, gender);
    }

    public Animal(String type) {
        this(type, 1, "Male");
    }

    public Animal() {
        this("Mammal", 1, "Male");
    }

    public void sound() {
        System.out.println("Communicate");
    }

    public void animalType() {
        System.out.println("Home raised");
    }

    @Override
    public String toString() {
        return "Animal [type=" + type + ", age=" + age + ", gender=" + gender + "]";
    }

}

class Dog extends Animal {

    private String breed;

    public Dog(int age, String gender) {
        super("Dog", age, gender);
    }

    public Dog(String breed, int age, String gender) {
        super("Dog", age, gender);
        this.breed = breed;
    }

    public Dog(String breed) {
        super("Dog");
        this.breed = breed;
    }

    public void sound() {
        super.sound();
        System.out.println("Bark Bark");
    }

    @Override
    public String toString() {
        return "Dog [type=" + super.type + " breed=" + breed + " age=" + super.age + ", gender=" + super.gender
                + "]";
    }
}