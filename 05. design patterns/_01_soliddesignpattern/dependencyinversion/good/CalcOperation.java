package _01_soliddesignpattern.dependencyinversion.good;

/*

    NOTES:
    - This is low level modules interface so anything to invoke in low level modules needs to go via this interface
    -  By this, we will achieve both loosely couple between high level and low level moduler and abstraction as well

 */

public interface CalcOperation {

    public int calcualate(int a, int b);

}
