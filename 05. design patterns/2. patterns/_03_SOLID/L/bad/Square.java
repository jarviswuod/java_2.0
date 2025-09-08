package _03_SOLID.L.bad;

public class Square extends Rectangle {

    // super.length = super.width;
    // super().width = super.length;

    @Override
    public double area() {
        return length * width;
    }
}
