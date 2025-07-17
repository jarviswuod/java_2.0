import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _13_CreatingHashSet {

    public static void main(String[] args) {

        // Creating an HashSet object using default constructor
        Set<String> fruits = new HashSet<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guavas");

        System.out.println(fruits);

        // Creating an HashSet object using Another Collection
        // 1. HashSet(Collection c) constructor
        // 2. Adding Existing elements to a new HashSet.addAll()

        // Set<Integer> firstFivePrimeNumbers = new HashSet<>();
        List<Integer> firstFivePrimeNumbers = new ArrayList<>();
        firstFivePrimeNumbers.add(2);
        firstFivePrimeNumbers.add(3);
        firstFivePrimeNumbers.add(5);
        firstFivePrimeNumbers.add(7);
        firstFivePrimeNumbers.add(11);

        Set<Integer> firstTenPrimeNumbers = new HashSet<>(firstFivePrimeNumbers);

        // Set<Integer> nextFivePrimeNumbers = new HashSet<>();
        List<Integer> nextFivePrimeNumbers = new ArrayList<>();
        nextFivePrimeNumbers.add(2);
        nextFivePrimeNumbers.add(3);
        nextFivePrimeNumbers.add(5);
        nextFivePrimeNumbers.add(7);
        nextFivePrimeNumbers.add(11);

        firstTenPrimeNumbers.addAll(nextFivePrimeNumbers);
        System.out.println(firstTenPrimeNumbers);
    }
}
