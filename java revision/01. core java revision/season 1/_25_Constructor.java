/*

    OFFHEAD NOTES:
     - 2 types
          - default
          - parametized

 */

public class _25_Constructor {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Jarvis", 15);
        Student student3 = new Student("Wuod", 16);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}

class Student {

    private int age;
    private String name;

    public Student() {
        age = 14;
        name = "Unknown";
    }

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}