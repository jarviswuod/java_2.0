package _01_soliddesignpattern.dependencyinversion.good;

public class SubOperation implements CalcOperation {
    @Override
    public int calcualate(int a, int b) {
        return a - b;
    }
}
