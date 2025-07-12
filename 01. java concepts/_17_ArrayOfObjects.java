public class _17_ArrayOfObjects {

    public static void main(String[] args) {
        Student student1 = new Student("Jarvis", 14, 1, "red");
        Student student2 = new Student("Becky", 22, 3, "green");
        Student student3 = new Student("Annie", 23, 2, "champ");
        Student student4 = new Student("Alfred", 11, 1, "winners");
        Student student5 = new Student("Chris", 12, 4, "east");

        Student[] students = { student1, student2, student3, student4, student5 };

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    String name;
    int age;
    int form;
    String stream;

    public Student(String name, int age, int form, String stream) {
        this.name = name;
        this.age = age;
        this.form = form;
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", form=" + form + ", stream=" + stream + "]";
    }

}