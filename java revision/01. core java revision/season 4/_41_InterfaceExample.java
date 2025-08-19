/*

    NOTES:
    - 

 */

public class _41_InterfaceExample {

    public static void main(String[] args) {
        Computer esktop = new Desktop();
        Computer aptop = new Laptop();
        Programmer grammer = new Programmer();

        grammer.canCode(aptop);
        grammer.canCode(esktop);

    }
}

interface Computer {

    void writeCode();
}

class Desktop implements Computer {

    @Override
    public void writeCode() {
        System.out.println("Fast Fast Fast");
    }
}

class Laptop implements Computer {

    @Override
    public void writeCode() {
        System.out.println("Fast");
    }
}

class Programmer {
    void canCode(Computer com) {
        com.writeCode();
    }
}