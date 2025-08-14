/*

    NOTES:
    - Overloading the same method to allow different parameters types say Integer, Double, etc
        - public Double sumAnyValues(List<Long> listOfAnyVal) {...}
        - public Double sumAnyValues(List<Double> listOfAnyVal) {...}
        - public Double sumAnyValues(List<Number> listOfAnyVal) {...}
        - public Double sumAnyValues(List<Integer> listOfAnyVal) {...}

        - Generics are compile time factors to help us solve for type safety for either adding or getting ONLY a specific type of element and at the end, all the 4 overloaded methods are the same in runtime


    - Generics is a complile time concept and gets stripped off in runtime
            public static Double sumAnyValues(List<? extends Number> listOfAnyVal) {

                double sum = 0;
                for (Number values : listOfAnyVal) {
                    sum += values.doubleValue();
                }

                return sum;
            }

 */

public class _07_UpperWildCard {
}