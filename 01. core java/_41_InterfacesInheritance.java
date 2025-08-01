/*

    NOTES:
       - extends → class to class (inheritance)
       - extends → interface to interface (interface inheritance)
       - implements → class to interface (implementation)
   
       - A class can implement multiple interfaces
       - An interface can extend multiple interfaces
       - A class can only extend one class (no multiple class inheritance)

 */

public class _41_InterfacesInheritance {
    public static void main(String[] args) {
        X obj1 = new B();

        obj1.show();
        obj1.config();

        System.out.println();

        Y obj2 = new B();
        obj2.run();

    }
}

interface X {
    void show();

    void config();
}

interface Y {
    void run();
}

interface Z extends Y {
    void code();
}

class B implements X, Z {

    public void run() {
        System.out.println("code() in interface Y");
    }

    public void code() {
        System.out.println("code() in interface Z");
    }

    public void show() {
        System.out.println("show() in interface X");
    }

    public void config() {
        System.out.println("config() in interface X");
    }
}
