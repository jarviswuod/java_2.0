package _01_soliddesignpattern.dependencyinversion.bad;

/*

    NOTES:
    - One sub module for Addition

 */

public class AddOperation {
    public int add(int a, int b) {
        return a + b;
    }
}
