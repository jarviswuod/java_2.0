/*
 NOTES:
  Overload
    - same method name
    - different number of params
    - different types of params
    - same class

 */

public class _15_MethodOverloading {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Jarvis";
        student.birthYear = 2003;

        System.out.println(student.name);
        System.out.println(student.birthYear);

        student.calcAge();
        student.calcAge(2024);
    }
}

class Student {
    String name;
    int birthYear;

    void calcAge() {
        System.out.println(2025 - birthYear);
    }

    void calcAge(int yearOfBirth) {
        System.out.println(2025 - yearOfBirth);
    }
}