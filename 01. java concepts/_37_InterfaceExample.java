public class _37_InterfaceExample {
    public static void main(String[] args) {
        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Developer dev = new Developer();
        dev.devApp(lap);

        System.out.println();

        dev.devApp(desk);
    }
}

class Developer {
    public void devApp(Computer lap) {
        lap.code();
    }
}

interface Computer {
    void code();
}

class Laptop implements Computer {

    public void code() {
        System.out.println("Code, complie, run : Fast");
    }
}

class Desktop implements Computer {

    public void code() {
        System.out.println("Code, complie, run : Faster");
    }
}
