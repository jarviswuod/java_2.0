/*

    NOTES:
    - Type parameter
        - Bounded type parameter:
            - Upper bounded Type Parameter: <T extends Type>
            - Lower bounded Type Parameter: <T super Type>

        - Unbounded type parameter
            - <T>


    - Bound mismatch
        - Exception thrown when Generics experiences mismatches


    - Wildcard
        - Bounded:
            - Upper bounded wildcard <? extends Type>
            - Lower bounded wildcard <? super Type>

        - Unbounded:
            - <?>


    - Variance Types:
        - Covariance
            - When a specific thing is needed a more specific one can be provided
            - By default java is covariant
            - Covariance in generics:
                - For generics to be Covariant, introduce extends keyword (Upper bounded wildcard)
                - This makes generics readOnly
                - Values are read by what we introduce as upper limit
                - No casting is allowed as we can be having a different datatype list/variable than the one we provided
                - WRITE operation is restriced as we can potentially add a value to a different variable


        - Invariance
            - Value provided should excatly be the one needed
            - Invariance in Generics:
                - Generics is invariant by default (<T>)
                - Invariance allows both READ and WRITE operations


        - Contravariance
            - This mean when a value is needed you actually provide a larger value
            - Contravariance in generics:
                - We make generics contravariant by introducing the super keyword: Setting the lower bound (<? super Type>)
                - super keyword enables generics perform both READ and WRITE operation.
                    - However we perform only WRITE operations as it only accepts bigger and bigger values add a small value makes sense logically
                    - READ operation is not allowed as we;
                        - Only allowed to read in the uppermost super class OBJECT
                        - No casting operation is allowed


    - Methods in Generics:
        - Methods in Unbounded generics:
            - No method calls are allowed and the only ones allowed are OBJECT superclass type methods;
                - This is because we can have any subclass and a specific method does not apply to another sub class

        - Methods in Bounded generics:
            - Method calls are allowed are long as it's within the method is defined by the class limit or inherited by it

 */

import java.util.List;

public class _00_OffHead {

    public static void main(String[] args) {

        List<Integer> intList = List.of(12, 34, 23, 90, 54, 21);
        List<Number> numList = List.of(12, 34, 23, 90, 54, 21);

        add(numList);
        addParam(intList);
    }

    public static void add(List<Number> list) {

        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        System.out.println("Sum : " + sum);

    }

    public static <T extends Number> void addParam(List<T> list) {
    }

}

class Home<T> {

    private T firstT;
    private T secondT;

    public Home(T firstT, T secondT) {
        this.firstT = firstT;
        this.secondT = secondT;
    }

    @Override
    public String toString() {
        return "Home [firstT=" + firstT + ", secondT=" + secondT + "]";
    }

}

class Animal {
}
