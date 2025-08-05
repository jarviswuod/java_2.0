/*

    Variables are static and final in interfaces
    concrete methods are static and default only
    mulitple 'abstract' and 'static' methods but only one default method

 */

public class _37_Interface {
    public static void main(String[] args) {
        Animal animal = new Fish();
        animal.name();
    }
}

interface Animal {
    String name = "Jarvis";

    void name();
}

class Fish implements Animal {
    public void name() {
        System.out.println("NAME HERE");
    }
}