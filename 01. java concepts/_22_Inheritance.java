public class _22_Inheritance {

    public static void main(String[] args) {
        veryAdvancedCalc calc = new veryAdvancedCalc();

        int r1 = calc.add(4, 3, 9);
        int r2 = calc.multiply(98, 54);
        double r3 = calc.power(4, 6);
        double r4 = calc.power(23, 10);

        System.out.println("r1 : " + r1);
        System.out.println("r2 : " + r2);
        System.out.println("r3 : " + r3);
        System.out.println("r4 : " + r4);
    }
}

class Calc {
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

class AdvancedCalc extends Calc {
    public int numberSquared(int num) {
        return num * num;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}

class veryAdvancedCalc extends AdvancedCalc {
    public double power(int num1, int num2) {
        return Math.pow(num1, num2);
    }
}