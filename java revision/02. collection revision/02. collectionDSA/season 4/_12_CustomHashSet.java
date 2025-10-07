/*

    NOTES:
    - KEY methods:
        - hashCode()
        - equals()

    - Explanantion:
        - When creating new set a process is followed where we look at the hashcode of the new element against all the existing elements if it doesnot exist we proceed to creating the Custom object else we dont create it

 */

import java.util.HashSet;
import java.util.Set;

public class _12_CustomHashSet {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Jarvis", 90));
        students.add(new Student("Wuod", 88));
        students.add(new Student("Jarvis", 77));
        students.add(new Student("Jarvis", 46));
        students.add(new Student("Jarvis", 90));

        // System.out.println(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

}

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + marks;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (marks != other.marks)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", marks=" + marks + "]";
    }
}