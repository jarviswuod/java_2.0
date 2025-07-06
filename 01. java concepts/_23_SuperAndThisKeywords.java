public class _23_SuperAndThisKeywords {
    public static void main(String[] args) {
        // B obj = new B();
        B obj = new B(5);
        obj.equals(obj);

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.toString());

        Rectangle rectangle2 = new Rectangle(12, 43);
        System.out.println(rectangle2.toString());

        Rectangle rectangle3 = new Rectangle(43);
        System.out.println(rectangle3.toString());
    }
}

class A {
    public A() {
        super();
        System.out.println("In A");
    }

    public A(int n) {
        super();
        System.out.println("In A int");
    }
}

class B extends A {
    public B() {
        super();
        System.out.println("In B");
    }

    public B(int n) {
        // super(n);
        this();
        System.out.println("In B int");
    }
}

// 2. Constructor Chaining with this()
class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this(1.0, 1.0); // Calls the two-parameter constructor
    }

    public Rectangle(double side) {
        this(side, side); // Calls the two-parameter constructor
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }
}

/*
 * // 3. Method Chaining (Fluent Interface)
 * class StringBuilder {
 * private String content = "";
 * 
 * public StringBuilder append(String text) {
 * this.content += text;
 * return this; // Returns current object for chaining
 * }
 * 
 * public StringBuilder reverse() {
 * this.content = new StringBuilder(this.content).reverse().toString();
 * return this;
 * }
 * 
 * public String build() {
 * return this.content;
 * }
 * }
 * 
 * // Usage:
 * StringBuilder sb = new StringBuilder()
 * .append("Hello")
 * .append(" ")
 * .append("World")
 * .reverse();
 * 
 */

// 4. Passing Current Object as Parameter
class EventHandler {
    private String name;

    public EventHandler(String name) {
        this.name = name;
        EventManager.register(this); // Pass current object to manager
    }

    public void handleEvent() {
        System.out.println(this.name + " handling event");
    }
}

class EventManager {
    static void register(EventHandler handler) {
        // Register the handler
    }
}

/*
 * # Java Super and This Keywords: Complete Guide
 * 
 * ## Table of Contents
 * 1. [Basic Concepts](#basic-concepts)
 * 2. [The `this` Keyword](#the-this-keyword)
 * 3. [The `super` Keyword](#the-super-keyword)
 * 4. [Advanced Usage Patterns](#advanced-usage-patterns)
 * 5. [Common Pitfalls and Best Practices](#common-pitfalls-and-best-practices)
 * 6. [Practice Tests](#practice-tests)
 * 
 * ---
 * 
 * ## Basic Concepts
 * 
 * ### What are `this` and `super`?
 ** 
 * `this`** - A reference to the current object instance
 ** `super`** - A reference to the parent class (superclass) of the current
 * object
 * 
 * These keywords are fundamental to object-oriented programming in Java,
 * enabling proper encapsulation, inheritance, and method resolution.
 * 
 * ---
 * 
 * ## The `this` Keyword
 * 
 * ### 1. Basic Usage - Resolving Name Conflicts
 * 
 * ```java
 * public class Person {
 * private String name;
 * private int age;
 * 
 * // Constructor with parameters matching field names
 * public Person(String name, int age) {
 * this.name = name; // this.name refers to the field
 * this.age = age; // age refers to the parameter
 * }
 * 
 * // Setter method
 * public void setName(String name) {
 * this.name = name; // Without 'this', we'd assign parameter to itself
 * }
 * 
 * public void printInfo() {
 * System.out.println("Name: " + this.name + ", Age: " + this.age);
 * // 'this' is optional here since there's no name conflict
 * }
 * }
 * ```
 * 
 * ### 2. Constructor Chaining with `this()`
 * 
 * ```java
 * public class Rectangle {
 * private double width;
 * private double height;
 * 
 * // Default constructor
 * public Rectangle() {
 * this(1.0, 1.0); // Calls the two-parameter constructor
 * }
 * 
 * // Single parameter constructor (square)
 * public Rectangle(double side) {
 * this(side, side); // Calls the two-parameter constructor
 * }
 * 
 * // Two-parameter constructor
 * public Rectangle(double width, double height) {
 * this.width = width;
 * this.height = height;
 * }
 * 
 * public double getArea() {
 * return this.width * this.height;
 * }
 * }
 * ```
 * 
 * ### 3. Method Chaining (Fluent Interface)
 * 
 * ```java
 * public class StringBuilder {
 * private String content = "";
 * 
 * public StringBuilder append(String text) {
 * this.content += text;
 * return this; // Returns current object for chaining
 * }
 * 
 * public StringBuilder reverse() {
 * this.content = new StringBuilder(this.content).reverse().toString();
 * return this;
 * }
 * 
 * public String build() {
 * return this.content;
 * }
 * }
 * 
 * // Usage:
 * StringBuilder sb = new StringBuilder()
 * .append("Hello")
 * .append(" ")
 * .append("World")
 * .reverse();
 * ```
 * 
 * ### 4. Passing Current Object as Parameter
 * 
 * ```java
 * public class EventHandler {
 * private String name;
 * 
 * public EventHandler(String name) {
 * this.name = name;
 * EventManager.register(this); // Pass current object to manager
 * }
 * 
 * public void handleEvent() {
 * System.out.println(this.name + " handling event");
 * }
 * }
 * 
 * class EventManager {
 * static void register(EventHandler handler) {
 * // Register the handler
 * }
 * }
 * ```
 * 
 * ---
 * 
 * ## The `super` Keyword
 * 
 * ### 1. Basic Usage - Accessing Parent Class Members
 * 
 * ```java
 * class Animal {
 * protected String species;
 * protected int age;
 * 
 * public Animal(String species, int age) {
 * this.species = species;
 * this.age = age;
 * }
 * 
 * public void makeSound() {
 * System.out.println("Some generic animal sound");
 * }
 * 
 * protected void sleep() {
 * System.out.println("Animal is sleeping");
 * }
 * }
 * 
 * class Dog extends Animal {
 * private String breed;
 * 
 * public Dog(String breed, int age) {
 * super("Canine", age); // Call parent constructor
 * this.breed = breed;
 * }
 * 
 * @Override
 * public void makeSound() {
 * super.makeSound(); // Call parent method first
 * System.out.println("Woof! Woof!");
 * }
 * 
 * public void displayInfo() {
 * System.out.println("Species: " + super.species); // Access parent field
 * System.out.println("Breed: " + this.breed);
 * System.out.println("Age: " + super.age);
 * }
 * 
 * public void rest() {
 * super.sleep(); // Call protected parent method
 * }
 * }
 * ```
 * 
 * ### 2. Constructor Chaining with `super()`
 * 
 * ```java
 * class Vehicle {
 * protected String make;
 * protected String model;
 * protected int year;
 * 
 * public Vehicle(String make, String model, int year) {
 * this.make = make;
 * this.model = model;
 * this.year = year;
 * }
 * 
 * public Vehicle(String make, String model) {
 * this(make, model, 2023); // Call another constructor in same class
 * }
 * }
 * 
 * class Car extends Vehicle {
 * private int doors;
 * private String fuelType;
 * 
 * public Car(String make, String model, int year, int doors, String fuelType) {
 * super(make, model, year); // Must be first statement
 * this.doors = doors;
 * this.fuelType = fuelType;
 * }
 * 
 * public Car(String make, String model, int doors) {
 * super(make, model); // Calls parent's two-parameter constructor
 * this.doors = doors;
 * this.fuelType = "Gasoline";
 * }
 * }
 * ```
 * 
 * ### 3. Method Overriding and Super Calls
 * 
 * ```java
 * class Shape {
 * protected double area;
 * 
 * public void calculateArea() {
 * System.out.println("Calculating area for generic shape");
 * }
 * 
 * public void display() {
 * System.out.println("This is a shape with area: " + area);
 * }
 * }
 * 
 * class Circle extends Shape {
 * private double radius;
 * 
 * public Circle(double radius) {
 * this.radius = radius;
 * }
 * 
 * @Override
 * public void calculateArea() {
 * super.calculateArea(); // Call parent method
 * this.area = Math.PI * radius * radius;
 * System.out.println("Circle area calculated: " + area);
 * }
 * 
 * @Override
 * public void display() {
 * super.display(); // Call parent display
 * System.out.println("Radius: " + radius);
 * }
 * }
 * ```
 * 
 * ---
 * 
 * ## Advanced Usage Patterns
 * 
 * ### 1. Complex Constructor Chaining
 * 
 * ```java
 * class Person {
 * protected String firstName;
 * protected String lastName;
 * protected int age;
 * 
 * public Person(String firstName, String lastName, int age) {
 * this.firstName = firstName;
 * this.lastName = lastName;
 * this.age = age;
 * }
 * 
 * public Person(String firstName, String lastName) {
 * this(firstName, lastName, 0);
 * }
 * }
 * 
 * class Employee extends Person {
 * private String employeeId;
 * private double salary;
 * private String department;
 * 
 * // Full constructor
 * public Employee(String firstName, String lastName, int age,
 * String employeeId, double salary, String department) {
 * super(firstName, lastName, age);
 * this.employeeId = employeeId;
 * this.salary = salary;
 * this.department = department;
 * }
 * 
 * // Constructor without age
 * public Employee(String firstName, String lastName, String employeeId,
 * double salary, String department) {
 * super(firstName, lastName); // Age defaults to 0
 * this.employeeId = employeeId;
 * this.salary = salary;
 * this.department = department;
 * }
 * 
 * // Constructor with minimal info
 * public Employee(String firstName, String lastName, String employeeId) {
 * this(firstName, lastName, employeeId, 0.0, "Unassigned");
 * }
 * }
 * ```
 * 
 * ### 2. Abstract Classes and Template Method Pattern
 * 
 * ```java
 * abstract class DatabaseConnection {
 * protected String connectionString;
 * 
 * public DatabaseConnection(String connectionString) {
 * this.connectionString = connectionString;
 * }
 * 
 * // Template method
 * public final void connect() {
 * openConnection();
 * authenticate();
 * setupSession();
 * }
 * 
 * protected abstract void openConnection();
 * protected abstract void authenticate();
 * 
 * protected void setupSession() {
 * System.out.println("Setting up default session");
 * }
 * }
 * 
 * class MySQLConnection extends DatabaseConnection {
 * private String username;
 * private String password;
 * 
 * public MySQLConnection(String connectionString, String username, String
 * password) {
 * super(connectionString);
 * this.username = username;
 * this.password = password;
 * }
 * 
 * @Override
 * protected void openConnection() {
 * System.out.println("Opening MySQL connection to: " + super.connectionString);
 * }
 * 
 * @Override
 * protected void authenticate() {
 * System.out.println("Authenticating with username: " + this.username);
 * }
 * 
 * @Override
 * protected void setupSession() {
 * super.setupSession(); // Call parent's setup
 * System.out.println("Setting up MySQL-specific session parameters");
 * }
 * }
 * ```
 * 
 * ### 3. Interface Default Methods and Super
 * 
 * ```java
 * interface Drawable {
 * default void draw() {
 * System.out.println("Drawing using default method");
 * }
 * 
 * void render();
 * }
 * 
 * interface Colorable {
 * default void draw() {
 * System.out.println("Drawing with color");
 * }
 * 
 * void setColor(String color);
 * }
 * 
 * class ColoredShape implements Drawable, Colorable {
 * private String color;
 * 
 * @Override
 * public void draw() {
 * Drawable.super.draw(); // Call specific interface default method
 * Colorable.super.draw(); // Call other interface default method
 * System.out.println("Drawing colored shape with color: " + this.color);
 * }
 * 
 * @Override
 * public void render() {
 * System.out.println("Rendering colored shape");
 * }
 * 
 * @Override
 * public void setColor(String color) {
 * this.color = color;
 * }
 * }
 * ```
 * 
 * ### 4. Inner Classes and Qualified `this`
 * 
 * ```java
 * class Outer {
 * private int outerField = 10;
 * 
 * class Inner {
 * private int innerField = 20;
 * 
 * public void method() {
 * System.out.println("Inner field: " + this.innerField);
 * System.out.println("Outer field: " + Outer.this.outerField);
 * 
 * // If Inner class had a field with same name as outer
 * int outerField = 30;
 * System.out.println("Local variable: " + outerField);
 * System.out.println("Inner's outer field: " + Outer.this.outerField);
 * }
 * }
 * 
 * public void createInner() {
 * Inner inner = this.new Inner(); // Qualified instantiation
 * inner.method();
 * }
 * }
 * ```
 * 
 * ---
 * 
 * ## Common Pitfalls and Best Practices
 * 
 * ### 1. Constructor Chaining Rules
 * 
 * ```java
 * class BadExample {
 * private int value;
 * 
 * public BadExample() {
 * System.out.println("Setting up...");
 * this(10); // ERROR: this() must be first statement
 * }
 * 
 * public BadExample(int value) {
 * this.value = value;
 * }
 * }
 * 
 * class GoodExample {
 * private int value;
 * 
 * public GoodExample() {
 * this(10); // Correct: this() is first statement
 * // Additional setup can be done in the target constructor
 * }
 * 
 * public GoodExample(int value) {
 * this.value = value;
 * System.out.println("Setting up with value: " + value);
 * }
 * }
 * ```
 * 
 * ### 2. Super Constructor Call Requirements
 * 
 * ```java
 * class Parent {
 * private String name;
 * 
 * // No default constructor - only parameterized constructor
 * public Parent(String name) {
 * this.name = name;
 * }
 * }
 * 
 * class Child extends Parent {
 * private int age;
 * 
 * // ERROR: Implicit super() call fails because Parent has no default
 * constructor
 * // public Child(int age) {
 * // this.age = age; // Compile error
 * // }
 * 
 * // Correct: Explicit super() call
 * public Child(int age) {
 * super("Unknown"); // Must call parent constructor explicitly
 * this.age = age;
 * }
 * 
 * public Child(String name, int age) {
 * super(name);
 * this.age = age;
 * }
 * }
 * ```
 * 
 * ### 3. Method Hiding vs. Overriding
 * 
 * ```java
 * class Parent {
 * public void instanceMethod() {
 * System.out.println("Parent instance method");
 * }
 * 
 * public static void staticMethod() {
 * System.out.println("Parent static method");
 * }
 * }
 * 
 * class Child extends Parent {
 * 
 * @Override
 * public void instanceMethod() {
 * super.instanceMethod(); // Calls parent's overridden method
 * System.out.println("Child instance method");
 * }
 * 
 * // This hides the parent's static method (not overriding)
 * public static void staticMethod() {
 * // super.staticMethod(); // ERROR: Cannot use super with static methods
 * Parent.staticMethod(); // Correct way to call parent static method
 * System.out.println("Child static method");
 * }
 * }
 * ```
 * 
 * ### 4. Best Practices
 * 
 * ```java
 * // Good: Clear parameter names and proper this usage
 * class Person {
 * private final String name;
 * private final int age;
 * 
 * public Person(String name, int age) {
 * this.name = Objects.requireNonNull(name, "Name cannot be null");
 * this.age = age;
 * }
 * 
 * public Person withAge(int newAge) {
 * return new Person(this.name, newAge); // Immutable object pattern
 * }
 * }
 * 
 * // Good: Proper super usage in inheritance
 * class Employee extends Person {
 * private final String department;
 * 
 * public Employee(String name, int age, String department) {
 * super(name, age);
 * this.department = Objects.requireNonNull(department,
 * "Department cannot be null");
 * }
 * 
 * @Override
 * public String toString() {
 * return super.toString() + ", Department: " + this.department;
 * }
 * }
 * ```
 * 
 * ---
 * 
 * ## Practice Tests
 * 
 * ### Test 1: Basic Understanding
 * ```java
 * class Test1 {
 * private int value = 10;
 * 
 * public Test1() {
 * this(20);
 * }
 * 
 * public Test1(int value) {
 * this.value = value;
 * }
 * 
 * public void print() {
 * System.out.println("Value: " + this.value);
 * }
 * }
 * 
 * // Question: What will be printed when we create new Test1() and call
 * print()?
 * // Answer: Value: 20
 * ```
 * 
 * ### Test 2: Constructor Chaining
 * ```java
 * class A {
 * public A() {
 * System.out.println("A default");
 * }
 * 
 * public A(int x) {
 * System.out.println("A parameterized: " + x);
 * }
 * }
 * 
 * class B extends A {
 * public B() {
 * System.out.println("B default");
 * }
 * 
 * public B(int x) {
 * super(x);
 * System.out.println("B parameterized: " + x);
 * }
 * }
 * 
 * // Question: What's the output of new B(5)?
 * // Answer:
 * // A parameterized: 5
 * // B parameterized: 5
 * ```
 * 
 * ### Test 3: Method Overriding
 * ```java
 * class Parent {
 * public void method() {
 * System.out.println("Parent method");
 * }
 * }
 * 
 * class Child extends Parent {
 * 
 * @Override
 * public void method() {
 * System.out.println("Child method");
 * super.method();
 * }
 * }
 * 
 * // Question: What happens when we call new Child().method()?
 * // Answer:
 * // Child method
 * // Parent method
 * ```
 * 
 * ### Test 4: Complex Scenario
 * ```java
 * class Vehicle {
 * protected String type;
 * 
 * public Vehicle(String type) {
 * this.type = type;
 * System.out.println("Vehicle created: " + type);
 * }
 * }
 * 
 * class Car extends Vehicle {
 * private String brand;
 * 
 * public Car(String brand) {
 * super("Car");
 * this.brand = brand;
 * System.out.println("Car created: " + brand);
 * }
 * 
 * public Car(String type, String brand) {
 * super(type);
 * this.brand = brand;
 * System.out.println("Custom car created: " + brand);
 * }
 * }
 * 
 * // Question: What's the output of new Car("Toyota") and new Car("SUV",
 * "Honda")?
 * // Answer:
 * // new Car("Toyota"):
 * // Vehicle created: Car
 * // Car created: Toyota
 * //
 * // new Car("SUV", "Honda"):
 * // Vehicle created: SUV
 * // Custom car created: Honda
 * ```
 * 
 * ### Test 5: Tricky Question
 * ```java
 * class Base {
 * public Base() {
 * method();
 * }
 * 
 * public void method() {
 * System.out.println("Base method");
 * }
 * }
 * 
 * class Derived extends Base {
 * private String value = "Initialized";
 * 
 * public Derived() {
 * super();
 * System.out.println("Derived constructor");
 * }
 * 
 * @Override
 * public void method() {
 * System.out.println("Derived method: " + value);
 * }
 * }
 * 
 * // Question: What happens when we create new Derived()?
 * // Answer:
 * // Derived method: null
 * // Derived constructor
 * //
 * // Explanation: The overridden method is called during super() construction,
 * // but the field initialization hasn't happened yet, so value is null.
 * ```
 * 
 * ---
 * 
 * ## Summary
 * 
 * The `this` and `super` keywords are essential for:
 * 
 * 1. **`this`**: Referencing current object, resolving name conflicts,
 * constructor chaining within the same class, method chaining, and passing
 * current object as parameter.
 * 
 * 2. **`super`**: Accessing parent class members, calling parent constructors,
 * method overriding with parent method calls, and resolving method conflicts in
 * inheritance.
 ** 
 * Key Rules:**
 * - `this()` and `super()` must be the first statement in constructors
 * - Cannot use `super` with static methods
 * - Constructor chaining follows a specific order
 * - Method overriding vs. method hiding behaves differently
 * - Field initialization order matters in inheritance
 ** 
 * Best Practices:**
 * - Use `this` for clarity even when not required
 * - Always call `super()` explicitly when parent has no default constructor
 * - Be careful with method calls in constructors
 * - Use qualified `this` in inner classes when needed
 * - Prefer composition over inheritance when appropriate
 */