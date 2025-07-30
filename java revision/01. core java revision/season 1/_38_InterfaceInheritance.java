/*

    OFFHEAD NOTES:
      - extends → class to class (inheritance)
      - extends → interface to interface (interface inheritance)
      - implements → class to interface (implementation)
  
      - A class can implement multiple interfaces
      - An interface can extend multiple interfaces
      - A class can only extend one class (no multiple class inheritance)

 */

public class _38_InterfaceInheritance {

    public static void main(String[] args) {

    }
}

interface A {
    int age_ = 44;
    String name = "Area";

    void showing();

    void configure();
}

interface B {
    int age = 44;
    String area = "Area";

    void show();

    void config();
}

interface C extends B {

    void configInherited();
}

class Concrete implements A, C {

    @Override
    public void show() {
        System.out.println("show :");
    }

    @Override
    public void config() {
        System.out.println("config :");
    }

    @Override
    public void showing() {
        System.out.println("showing :");
    }

    @Override
    public void configure() {
        System.out.println("configure :");
    }

    @Override
    public void configInherited() {
        System.out.println("configInherited :");
    }

}