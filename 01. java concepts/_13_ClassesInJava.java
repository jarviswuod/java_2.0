public class _13_ClassesInJava {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setName("Jarvis");
        student1.setAge(11);

        student2.setName("Danny");
        student2.setAge(12);

        System.out.println("First Student is called : " + student1.getName());
        System.out.println("He is : " + student1.getAge());

        System.out.println();

        System.out.println("Second Student is called : " + student2.getName());
        System.out.println("He is : " + student2.getAge());

    }
}

class Student {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
