/*

    NOTES:
    - Intro:
        - PriorityQueue retrieves elements based on their priority, not insertion order.
        - Priority is determined by:
            1. Natural ordering (elements must implement Comparable)
            2. Total ordering (custom Comparator passed in the constructor)

        - Elements are **not** stored in sorted order; the heap structure only guarantees that the *head* element is the one with highest priority (smallest in a min-heap).
        - Traversal using an iterator **does not guarantee priority order** — it reflects internal heap structure.

        - DO NOT rely on iteration for processing elements in priority order. Use `poll()` repeatedly instead.


    - Comparable interface:
        - Whenever you are creating a custom class of type PriorityQueue. You should implement the Comparable class
            class StudentsMarks implements Comparable<StudentsMarks> {
                @Override
                public int compareTo(StudentsMarks arg1) {
                    return this.maths - arg1.maths;
                }
            }


    - Comparator interface:
        - Comparator Interface comes into place when we want to change sorting mechanism in the Interger class or our custom class

            class MyCustomComparator implements Comparator<Integer> {
                @Override
                public int compare(Integer arg0, Integer arg1) {
                    return arg1 - arg0;
                }
            }


    - Comparable VS Comparator interface
        - Comparable interface
            - This is ordering that our class is implementing
            - It's also called Natural ordering
            - compareTo() method override
                - PriorityQueue<Integer> value = new PriorityQueue<>();
                - PriorityQueue<StudentsMarks> orderedMarks = new PriorityQueue<>(marks);

        - Comparator interface
            - This is ordering passed to the PriorityQueue
            - It's also called Total ordering
            - compare() method override
                - PriorityQueue<Integer> ordIntegers = new PriorityQueue<>((a, b) -> b - a);
                - PriorityQueue<StudentsMarks> classMarks = new PriorityQueue<>(new MyCustomComparator());

        - Total ordering (by Comparator Interface) always has preference over Natural ordering (by Comparable Interface)

 */

public class _09_PriorityQueue {

}