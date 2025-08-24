package _01_soliddesignpattern.dependencyinversion.bad;

/*

    NOTES:
    - Calculator example:
        - We are utelizing our calculate example from Open closed.
        - Here we are having Calculator with add() and sub() functionality and user is sending choice for it.
        - This operations are called sub module in the system


    - Parent module or main module of calculator which helps to calculate as per user's choice
    - As per DIP rule which states;
        - High-level modules should not depend on low-level modules. Both should on abstractions
            - This rule is broken as our calculator class is directly dependent on low level class

        - Abstractions should not depend on details. Details should depend on abstractions
            - Broke this rule too as we dependent on the actual class

 */

public class Calculator {
    public int calcualate(int a, int b, String operation) {

        int result = 0;

        switch (operation) {
            case "add":
                AddOperation addOperation = new AddOperation();
                result = addOperation.add(a, b);
                break;
            case "sub":
                SubOperation subOperation = new SubOperation();
                result = subOperation.sub(a, b);
                break;

            default:
                result = 0;
                break;
        }
        return result;
    }
}