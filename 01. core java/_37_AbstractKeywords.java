///  Key Rules for Abstract Classes
/////////////////////////////////////////////////////////////////////////////

// 1. Cannot be instantiated: You can't use new with abstract classes
// 2. Can have constructors: Used when subclasses call super()
// 3. Can have concrete methods: Regular methods with implementation
// 4. Can have abstract methods: Methods without implementation
// 5. Subclasses must implement all abstract methods: Unless the subclass is also abstract
// 6. Can have fields: Both static and instance variables

/////////////////////////////////////////////////////////////////////////////
// Use abstract classes when:

// 1. You want to share common code among related classes
// 2. You want to force subclasses to implement certain methods
// 3. You have a base class that shouldn't be instantiated directly
// 4. You want to provide default implementations for some methods

/////////////////////////////////////////////////////////////////////////////
// Differences Btwn Abstract and interfaces:

// 1. Abstract classes can have constructors, interfaces cannot
// 2. Abstract classes can have concrete methods, interfaces mainly have abstract methods (except default/static methods)
// 3. A class can extend only one abstract class but implement multiple interfaces
// 4. Abstract classes can have any access modifier, interface methods are public by default

// ///////////////////////////////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////////////////////////
// MAIN EXAMPLE
// ///////////////////////////////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////////////////////////
public class _37_AbstractKeywords {
    public static void main(String[] args) {
        // Car car = new Car(); // Cannot instantiate the type Car

        Car car = new updatedWagonR();
        car.drive();
        car.playMusic();
        car.fly();
    }
}

abstract class Car { // Abstract class
    public abstract void drive();

    public abstract void fly();

    public void playMusic() {
        System.out.println("Playing Music");
    }
}

abstract class WagonR extends Car { // Abstract class
    public void drive() {
        System.out.println("WagonR driving");
    }

    public void fly() {
        System.out.println("WagonR flying NO...");
    }
}

class updatedWagonR extends WagonR { // Concrete class
    public void fly() {
        System.out.println("updatedWagonR flying...");
    }
}

// ///////////////////////////////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////////////////////////
// Example 2
// ///////////////////////////////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////////////////////////
class _33_AbstractKeywords_ {
    public static void main(String[] args) {
        // Animal animal = new Animal("Generic"); // ERROR!
        // Cannot instantiate abstract

        Dog dog = new Dog("Rex");
        Bird bird = new Bird("Tweety");

        dog.sleep();
        dog.makeSound();
        dog.move();

        System.out.println();

        bird.sleep();
        bird.makeSound();
        bird.move();

        System.out.println();

        Animal[] animals = { dog, bird };
        for (Animal animal : animals) {
            animal.makeSound();
            animal.move();
        }
    }
}

abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public abstract void makeSound();

    public abstract void move();
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet!");
    }

    @Override
    public void move() {
        System.out.println(name + " flies in the sky");
    }
}