/*
 
    Restricking access to varaibles and only making them accessible though set and get methods
    access modifiers is the way to make them accessible, private, public, protected, and default
 
 */

public class _23_Encapsulation {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Jarvis");
        student.setBirthYear(2024);

        System.out.println(student.getName());
        System.out.println(student.getBirthYear());
    }
}

class Student {
    private String name;
    private int birthYear;

    public void calcAge() {
        System.out.println(2025 - birthYear);
    }

    public void calcAge(int yearOfBirth) {
        System.out.println(2025 - yearOfBirth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

}