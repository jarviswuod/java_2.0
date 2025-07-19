public class _24_Encapsulation {

    /*
     * 
     * Encapuslation refers to the act of securely accessing varibles within a class
     * via a different method example(setName(), getName()) instead of directly
     * accessing it
     * 
     */

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