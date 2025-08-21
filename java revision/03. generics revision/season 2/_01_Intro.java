/*

    NOTES:
    - Keywords:
        - PECS rule
        - Get put rule

    - Variance:
        - Invariant
        - covariant
        - contravariant

    - Hows:
        - wildcards:
            - upper bounded -> 'extends' keyword :: covariant [ <? extends Type> ] -> Reading values
            - lower bounded -> 'super' keyword :: contravariant [ <? super Type> ] -> Adding values

        - Type parameter:
            - <T extends Type> upper bounded type parameter
            - <T super Type> lower bounded type parameter

    - Type mismatch:
        - No CREATE or UPDATE methods are allowed under extends
        - Type mismatch: Error and Mismatch

 */

public class _01_Intro {
}