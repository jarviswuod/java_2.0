/*

    NOTES:
    - Student[] students =  new Student[5];

 */

public class _19_ArrayOfObjects {
    public static void main(String[] args) {

        Student student1 = new Student("Jarvis");
        Student student2 = new Student("Pasca");
        Student student3 = new Student("Nis");
        Student student4 = new Student("Wuod");

        // Student[] students = new Student[4];
        // students[0] = student1;
        // students[1] = student2;
        // students[2] = student3;
        // students[3] = student4;

        Student[] students = { student1, student2, student3, student4 };

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }

}