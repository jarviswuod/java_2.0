/*
 * Stream is an interface
 * 
 * nums.stream() -> returns an object of stream
 * With this new variable you can perform any operation and its not gonna affect
 * the original values (preventing mutation of the origin values)
 * 
 * NOTE:
 * -> Once you use a stream you can't reuse it again
 * 
 * Benefits of stream
 * -> It provides a lot of methods you can work with example
 * --> filter, map, reduce, sorted
 * 
 * "parrallelStream" can be used for threads
 * 
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _63_StreamInterface {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4, 7, 6, 1, 9, 3);

        // No chaining
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
        int result1 = s3.reduce(0, ((c, e) -> c + e));

        // Method chaining
        int result2 = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, ((c, e) -> c + e));

        System.out.println(result1);
        System.out.println(result2);
    }
}