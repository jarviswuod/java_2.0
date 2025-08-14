/*

    NOTES:
    - Wild Cards <?>
        - This is an alternative for solving the generics invariance issue in generics, ignoring the generics method signature
            - public static Double sumAnyValues(List<?> listOfAnyVal) {...}

            - We can solve this issue by setting a bounded wild card. List of unknown type that extends Number
                - public Double sumAnyValues(List<? extends Number> listOfAnyVal) {...}

 */

public class _06_Wildcards {
}