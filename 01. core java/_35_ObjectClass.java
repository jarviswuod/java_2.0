// .equals()
// .toString()
// .hashcode()

public class _35_ObjectClass {
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
    private String name;
    private int age;
    private int form;
    private String stream;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + form;
        result = prime * result + ((stream == null) ? 0 : stream.hashCode());
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
        if (age != other.age)
            return false;
        if (form != other.form)
            return false;
        if (stream == null) {
            if (other.stream != null)
                return false;
        } else if (!stream.equals(other.stream))
            return false;
        return true;
    }

}