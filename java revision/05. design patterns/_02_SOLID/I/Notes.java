package _02_SOLID.I;

/*

    NOTES:
    - Interface Segregation principle:
        - 

        - Example


    - UnsupportedOperationException()
    - IllegalArgumentException()

 */

public class Notes {

    void dance(int i) {
        if (i > 1)
            throw new UnsupportedOperationException("No one is allowed to dance");
        else
            throw new IllegalArgumentException("Another error exception");
    }

}
