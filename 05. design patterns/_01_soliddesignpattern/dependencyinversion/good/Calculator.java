package _01_soliddesignpattern.dependencyinversion.good;

/*

    NOTES:
    - As per DIP rule which states:
        - High-level modules should not depend on low-level modules. Both should depend on abstractions
            - So low level is dependent via CalcOperation rather than begin depended on Addoperation or Suboperation
        
        - Abstraction should not depend on detials. Details should depend on abstractions
            - Abstraction is achieved as via interface we are entering in low level

 */

public class Calculator {
    public int calcualate(int a, int b, CalcOperation calcOperation) {
        return calcOperation.calcualate(a, b);
    }
}
