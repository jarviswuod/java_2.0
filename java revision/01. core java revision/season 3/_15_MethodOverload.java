public class _15_MethodOverload {

    public static void main(String[] args) {

        Student student = new Student();
        student.name = "Jarvis";
        student.age = 10;

        student.add();
        student.add("Jarvis");

        System.out.println(student.name);
        System.out.println(student.age);
    }
}

class Student {
    String name;
    int age;

    void add() {
        System.out.println("CODE");
    }

    void add(String student) {
        System.out.println("CODE : " + student);
    }
}