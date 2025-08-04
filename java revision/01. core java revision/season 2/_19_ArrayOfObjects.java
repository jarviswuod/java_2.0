public class _19_ArrayOfObjects {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Jarvis";
        student.age = 23;

        Student student1 = new Student();
        student1.name = "Jarvis";
        student1.age = 23;

        Student student2 = new Student();
        student2.name = "Jarvis";
        student2.age = 23;

        Student student3 = new Student();
        student3.name = "Jarvis";
        student3.age = 23;

        Student[] students_ = new Student[4];
        students_[0] = student;
        students_[1] = student1;
        students_[2] = student2;
        students_[3] = student3;

        Student[] students = { student, student1, student2, student3 };

        for (Student student_ : students) {
            System.out.println(student_);
        }

    }
}

class Student {
    String name;
    int age;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}