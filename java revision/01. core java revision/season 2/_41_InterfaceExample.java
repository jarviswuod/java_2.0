public class _41_InterfaceExample {

    public static void main(String[] args) {
        Developer developer = new Developer("Jarvis");

        Computer desktop = new Desktop();
        Computer laptop = new Laptop();

        // devCode(laptop);
        developer.devCode(desktop);
        developer.devCode(laptop);

    }
}

interface Computer {
    void writingCode();
}

class Desktop implements Computer {
    public void writingCode() {
        System.out.println("Code, debug, fast: Faster");
    }
}

class Laptop implements Computer {
    public void writingCode() {
        System.out.println("Code, debug, fast");
    }
}

class Developer {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void devCode(Computer com) {
        com.writingCode();
        System.out.println(this.name + " is writing code using a computer");
    }

    @Override
    public String toString() {
        return "Developer [name=" + name + "]";
    }

}