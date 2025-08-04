public class _14_Classes {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Jarvis";
        student.age = 23;

        System.out.println(student.name);
        System.out.println(student.age);
    }
}

class Student {
    String name;
    int age;
}