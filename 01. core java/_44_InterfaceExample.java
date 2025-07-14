public class _44_InterfaceExample {
    public static void main(String[] args) {

        Developer dev = new Developer();

        Computer lap = new Laptop();
        Computer desk = new Desktop();

        dev.devApp(lap);
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
