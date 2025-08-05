/*
 
Fucntional interface / Single abstract method -  one method
Marker interface -  no method
Normal interface - multiple methods
 */

public class _39_InterfaceType {
    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface Name {
    void showName();
}

// Normal interface
interface Person {
    void showPersonName();

    void showPerson();
}

// Marker interface
interface Instanciator {
}