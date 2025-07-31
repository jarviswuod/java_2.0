public class _41_InterfaceExample {

    public static void main(String[] args) {
        Machine lap = new Laptop();
        Machine desk = new Computer();

        Developer developer = new Developer("Jarvis");

        developer.codingTest();
        developer.prefertoCode(desk);
        System.out.println();
        developer.prefertoCode(lap);
    }
}

interface Machine {
    void code();
}

class Laptop implements Machine {

    @Override
    public void code() {
        System.out.println("Just Fucking code");
    }
}

class Computer implements Machine {

    @Override
    public void code() {
        System.out.println("Just Fucking code but faster");
    }
}

class Developer {

    public Developer(String name) {
        System.out.println("Welcome to our company " + name);
    }

    public void codingTest() {
        System.out.println("Im here to test your coding and typing skills ");
    }

    public void prefertoCode(Machine machine) {
        machine.code();
    }
}