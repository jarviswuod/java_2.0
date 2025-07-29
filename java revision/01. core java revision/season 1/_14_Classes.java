/*

    OFFHEAD NOTES:
      - Java is a strong OOP Language where everything is represented inform of objects
      - We create the object with help of classes

 */

public class _14_Classes {

    public static void main(String[] args) {

        Student student1 = new Student();

        student1.name = "Jarvis";
        student1.stream = "4 East";
        student1.age = 21;

        Student student2 = new Student();

        student2.name = "Wuod";
        student2.stream = "4 West";
        student2.age = 23;

        System.out.println(student1);
        System.out.println(student2);

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