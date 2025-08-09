public class _19_ArrayOfObjects {

    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();

        Student student0 = new Student();
        Student student1 = new Student();
        Student student2 = new Student();

        Student[] students1 = { student0, student1, student2 };
        for (Student student : students1) {
            System.out.println(student);
        }
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

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}