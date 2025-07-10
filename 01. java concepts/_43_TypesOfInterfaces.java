/*
 * 1. Normal Interface
 * -> Is an interface with 2 or more methods
 * 
 * 2. Functional Interface / Single Abstract Method (SAM)
 * -> Is an interface with ONLY one method
 * 
 * 3. Marker Interface
 * -> Is an inteface which has no methods
 * Reason --> To update something inside the compiler
 * Example --> 
 * ---> Serialization
 * ----> Taking an ovject and storing the values in your hard drive then destroy the object
 * 
 * ---> Deserialization
 * ----> Taking values from hard drive 
 * 
 */

public class _43_TypesOfInterfaces {
    public static void main(String[] args) {

    }
}

// 1. Normal Interface
interface Abc {
    void show();

    void displayBoth();
}

// 2. Functional Interface / SAM
interface Acb {
    void show();
}
