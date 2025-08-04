/*
 NOTES
 Statis keyword makes something the a class element and not an object element
 static varaibles are public 
 static method only have static variables, it has to be a part of an object
 concrete methods can have statis varaibles in them
 static keyword is used precisely for memory efficiency and shared access

 */

public class _21_StaticKeyword {

    public static void main(String[] args) {
        Student student = new Student("Jarvis");
        Student student1 = new Student("Wuod");

        student.showMore();
        System.out.println(Student.numberOfStudents);
        Student.show(student1);
    }
}

class Student {
    public static int numberOfStudents = 0;
    int value;
    String name;

    public Student(String name) {
        numberOfStudents++;
        value = 94;
        this.name = name;
    }

    static void show(Student student) {
        System.out.println("Without favour " + numberOfStudents + " " + student.name + " " + student.value);
    }

    void showMore() {
        System.out.println("Without favour " + numberOfStudents + " " + this.name + " " + this.value);
    }
}