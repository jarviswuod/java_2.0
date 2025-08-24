package _01_soliddesignpattern.openclosed;

/*

    NOTES:
    - This is good we keep adding new operation implementation 
    - Our calculator get extensions without modifying it's main task that is performing calculation

 */

public interface Operation {
    public int perform(int number1, int number2);
}
