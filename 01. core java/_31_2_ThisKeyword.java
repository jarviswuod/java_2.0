// 1. Basic Usage - Resolving Name Conflicts

public class _31_2_ThisKeyword {
    public static void main(String[] args) {

    }
}

class Person {
    private String name;
    private int age;

    // Constructor with parameters matching field names
    public Person(String name, int age) {
        this.name = name; // this.name refers to the field
        this.age = age; // age refers to the parameter
    }

    // Setter method
    public void setName(String name) {
        this.name = name; // Without 'this', we'd assign parameter to itself
    }

    public void printInfo() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
        // 'this' is optional here since there's no name conflict
    }
}