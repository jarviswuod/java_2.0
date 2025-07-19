public class _14_ClassesInJava {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.name = "Jarvis";
        student1.age = 11;

        student2.name = "Danny";
        student2.age = 12;

        System.out.println("First Student is called : " + student1.name);
        System.out.println("He is : " + student1.age);

        System.out.println();

        System.out.println("Second Student is called : " + student2.name);
        System.out.println("He is : " + student2.age);

    }
}

class Student {
    String name;
    int age;
}