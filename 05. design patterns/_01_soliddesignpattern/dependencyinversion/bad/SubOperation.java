package _01_soliddesignpattern.dependencyinversion.bad;

/*

    NOTES:
    - One sub module for substraction

 */

public class SubOperation {
    public int sub(int a, int b) {
        return a - b;
    }
}
