/*
    NOTES
    
    - Interfaces are not classes
    - By default every interface method is a public static
    - Every varaible in interfaces are final & static hence you have to initalize the variables

    - WHY DOES IT HAVE TO BE STATIC AND FINAL:
        1. You dont instantiate interfaces, whatever you instanciate is a class of which you'll be doing 'implements' not 'extends'. You can implements is methods
        2. Interface don't have their own memory in the heap
 */

public class _40_Interfaces {
    public static void main(String[] args) {

    }
}

interface B {
    int age = 44;
    String area = "Area";

    void show();

    void config();
}

abstract class A {
    public abstract void show();

    public abstract void config();
}
