public class _14_Classes {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "Jarvis";
        student1.age = 23;

        System.out.println(student1);
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