/*
 default
 parametetized
 works likver overriding
 */

public class _25_Constructor {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Jarvis");

        System.out.println(student1);
        System.out.println(student2);
    }
}

class Student {

    public Student() {
        System.out.println("New student default");
    }

    public Student(String name) {
        System.out.println("New student with name " + name);
    }
}
