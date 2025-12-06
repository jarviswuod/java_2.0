package _03_Design.Behavior.Mediator;

/*

    NOTES:
    - Is a structural design pattern that defines a bridge for communication between objects without the objects know of each other existance. Change in state of an object is communicated and reflected in other objects
    - Key players:
        - Mediator interface
        - Concrete Mediator
        - Component interface
        - Concrete Component

    - Exaple:
        - Text Editor changes
        - Observer pattern into play

*/

public class _01_Mediator {
    public static void main(String[] args) {

    }
}

interface _UIControl {

    void changed();
}
