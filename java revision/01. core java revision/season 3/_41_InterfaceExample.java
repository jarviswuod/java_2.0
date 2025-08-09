/*

 */

public class _41_InterfaceExample {

    public static void main(String[] args) {
        Developer developer = new Developer();

        Computer lap = new Laptop();
        Computer desk = new Desktop();

        developer.writeCode(lap);
        developer.writeCode(desk);

    }
}

interface Computer {
    void code();
}

class Desktop implements Computer {

    @Override
    public void code() {
        System.out.println("Coding Faster");
    }
}

class Laptop implements Computer {

    @Override
    public void code() {
        System.out.println("Coding Fast");
    }
}

class Developer {

    public void writeCode(Computer com) {
        com.code();
    }
}