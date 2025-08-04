/*

    NOTES:
    - default
    - parameteritized

 */

public class _25_Constructors {

    public static void main(String[] args) {

        Student student = new Student();
        Student student1 = new Student("Jarvis", 19);

        System.out.println(student.toString());
        System.out.println(student1.toString());

    }
}

class Student {
    private String name;
    private int age;

    public Student() {
        name = "Jarvis";
        age = 23;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}