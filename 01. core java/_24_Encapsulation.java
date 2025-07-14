public class _24_Encapsulation {
    public static void main(String[] args) {
        Human obj = new Human();

        obj.setAge(24);
        obj.setName("Jarvis");

        System.out.println(obj.getAge());
        System.out.println(obj.getName());
    }
}

class Human {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}