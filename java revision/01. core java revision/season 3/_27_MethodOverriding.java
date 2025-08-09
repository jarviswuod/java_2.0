/*
    NOTES
         - Same method name
         - different class, parent and child class
         - same varibles types, and number
         - different behavior

 */

public class _27_MethodOverriding {

    public static void main(String[] args) {

        RealCalc cal = new RealCalc();
        cal.sum(54);
        cal.sum(54, 12);
    }
}

class Calc {

    public void sum(int value1, int value2) {
        System.out.println(value1 + value2);
    }

    public void sum(int value1) {
        System.out.println(value1 + 5);
    }
}

class RealCalc extends Calc {
    public void sum(int value1, int value2) {
        System.out.println(value1 + value2 + 46);
    }

    public void sum(int value1) {
        System.out.println(value1 + 5 + 12);
    }
}