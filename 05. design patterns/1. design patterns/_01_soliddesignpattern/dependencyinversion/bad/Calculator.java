package _01_soliddesignpattern.dependencyinversion.bad;

public class Calculator {
    public int calcualate(int a, int b, String operation) {

        int result = 0;

        switch (operation) {
            case "add":
                AddOperation addOperation = new AddOperation();
                result = addOperation.add(a, b);
                break;
            case "sub":
                SubOperation subOperation = new SubOperation();
                result = subOperation.sub(a, b);
                break;

            default:
                result = 0;
                break;
        }
        return result;
    }
}