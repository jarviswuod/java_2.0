
public class _19_ArrayOfObjects {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();

        Student[] students = new Student[4];
        Student[] students_ = { student1, student2, student3, student4 };

        student1.name = "Jarvis";
        student1.age = 23;

        // System.out.println(student1);
        for (Student student : students_) {
            System.out.println(student);

        }
    }
}

class Student {
    int age;
    String name;

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}