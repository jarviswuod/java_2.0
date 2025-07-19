public class _27_InheritanceExample {

    public static void main(String[] args) {
        Student student1 = new Student("Stanley", 15, 1, "red");
        Student student2 = new Student("Becky", 22, 3, "green");
        Student student3 = new Student("Annayse", 23, 2, "champ");

        Guardian guardian1 = new Guardian("Jarvis", 24, 75464904, 38089372, "brother");
        Guardian guardian2 = new Guardian("Caroline", 36, 721281013, 26406881, "mother");

        Human[] everyone = { student1, student2, student3, guardian1, guardian2 };

        for (Human person : everyone) {
            System.out.println(person);
        }
    }
}

abstract class Human {
    protected String name;
    protected int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + "]";
    }
}

class Student extends Human {

    private int form;
    private String stream;

    public Student(String name, int age, int form, String stream) {
        super(name, age);

        this.form = form;
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", form=" + form + ", stream=" + stream + "]";
    }
}

class Guardian extends Human {
    private int phone;
    private int idNumber;
    private String relationship;

    public Guardian(String name, int age, int phone, int idNumber, String relationship) {
        super(name, age);

        this.phone = phone;
        this.idNumber = idNumber;
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "Guardian [name=" + name + ", age=" + age + ", phone=" + phone + ", idNumber=" + idNumber
                + ", relationship=" + relationship + ", toString()=" + super.toString() + "]";
    }
}