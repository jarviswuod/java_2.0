/*

    NOTES:
       - Encapsulation refers to hiding the internal state (fields/variables) of a class and restricting direct access to them.
       - It secures data by making fields `private` and exposing them through `public` getter/setter methods.
       - This ensures controlled access, improves code maintainability, and enforces data integrity.
       - Encapsulation is one of the core principles of OOP in Java.

 */

/*

    NOTES:
       - DIFFERENCE BETWEEN ACCESS MODIFIERS AND ENCAPSULATION
       - Encapsulation is a concept; access modifiers are tools used to implement it.

       - In simple terms:
          - Encapsulation = "Hide internal stuff and control access"
          - Access Modifiers = private, public, protected, default — used to control visibility

 */

public class _24_Encapsulation {

    public static void main(String[] args) {
        Human obj = new Human();

        obj.setAge(24);
        obj.setName("Jarvis");

        System.out.println(obj.getAge());
        System.out.println(obj.getName());
    }
}

class Human {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}