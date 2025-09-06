package _01_soliddesignpattern.dependencyinversion.good;

public class Calculator {
    public int calcualate(int a, int b, CalcOperation calcOperation) {
        return calcOperation.calcualate(a, b);
    }
}
