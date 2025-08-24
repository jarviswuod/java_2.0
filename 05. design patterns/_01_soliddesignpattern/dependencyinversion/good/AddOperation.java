package _01_soliddesignpattern.dependencyinversion.good;

/*

    NOTES:
    - So we will have this class but it will be taken care via interface implementation

 */

public class AddOperation implements CalcOperation {
    @Override
    public int calcualate(int a, int b) {
        return a + b;
    }
}
