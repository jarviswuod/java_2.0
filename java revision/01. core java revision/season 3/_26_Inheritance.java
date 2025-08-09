/*
 
    NOTES:
        child/sub class having access to parent methods and varibles

 */

public class _26_Inheritance {
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

}