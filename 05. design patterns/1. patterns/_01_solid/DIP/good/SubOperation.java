package _01_solid.DIP.good;

public class SubOperation implements CalcOperation {

    @Override
    public int calcualate(int a, int b) {
        return a - b;
    }
}
