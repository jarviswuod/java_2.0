public class _15_MethodOverloading {

    /*
     * Method Overloading
     * 
     * Referes to a multiple methods defined with:
     * 1. Same method name
     * 2. Different number of parameters
     * 3. Different parameter types
     * 4. Under the same class
     * 
     */

    public static void main(String[] args) {
        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();
        Calculator cal3 = new Calculator();

        cal1.add(11, 3);
        cal2.add(15, 14, 24);
        cal3.add(15, 14, 2.4f);

    }
}

class Calculator {
    public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public void add(int num1, int num2, int num3) {
        System.out.println(num1 + num2 + num3);
    }

    public void add(int num1, int num2, float num3) {
        System.out.println(num1 + num2 + num3);
    }
}