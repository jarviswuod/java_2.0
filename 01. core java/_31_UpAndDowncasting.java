/*
    NOTES:
       - Upcasting: Reference type is superclass, object is subclass
         e.g., Animal a = new Dog(); // Happens implicitly

       - Downcasting: Cast superclass reference back to subclass
         e.g., Dog d = (Dog) a; // To be done explicitly and safely


    Terms:
       - Reference class → the declared type (e.g., Animal a)
       - Object class → the actual object in memory (e.g., new Dog())

 */

public class _31_UpAndDowncasting {
    public static void main(String[] args) {
        // Upcasting
        Animal obj = new Dog();
        obj.show1();

        // Downcasting
        Dog obj1 = (Dog) obj;
        obj1.show2();

        // The method show2() is undefined for the type Animal
        // Animal obj1 = (Dog) obj;
        // obj1.show2();
    }
}

class Animal {
    public void show1() {
        System.out.println("In Animal");
    }
}

class Dog extends Animal {
    public void show2() {
        System.out.println("In Dog");
    }
}