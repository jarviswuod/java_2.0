/*

    OFFHEAD NOTES:
     - Array of objects stores multiple object instances of a class in a single variable
     - 2 ways of creating array of objects
        - Student[] students = new Student[3];
        - Student[] students = { student1, student2, student3 };

 */

public class _19_ArrayOfObjects {

    public static void main(String[] args) {

        Student[] students = new Student[3];

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        student1.name = "Jarvis";
        student1.stream = "4 East";
        student1.age = 21;

        student2.name = "Wuod";
        student2.stream = "4 West";
        student2.age = 24;

        student3.name = "Annabel";
        student3.stream = "3 South";
        student3.age = 18;

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    String name;
    String stream;
    int age;

    @Override
    public String toString() {
        return "Student [name=" + name + ", stream=" + stream + ", age=" + age + "]";
    }
}