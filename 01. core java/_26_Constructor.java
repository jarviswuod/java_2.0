/*

    NOTES:
       - Two main types of constructors in Java:
           - Default constructor: takes no arguments
           - Parameterized constructor: takes arguments to initialize fields
       - If no constructor is defined, Java provides a default one automatically
       - Constructors must have the same name as the class
       - Constructors do NOT have a return type
       - Can be overloaded (multiple constructors with different parameters)

 */

public class _26_Constructor {

    public static void main(String[] args) {
        Human obj = new Human();
        Human obj2 = new Human(24, "Jarvis");

        System.out.println(obj.getAge());
        System.out.println(obj.getName());

        System.out.println(obj2.getAge());
        System.out.println(obj2.getName());

    }
}

class Human {
    private String name;
    private int age;

    public Human() { // Default constructor
        name = "Wuod";
        age = 20;
    }

    public Human(int age, String name) { // Parameterized constructor
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}