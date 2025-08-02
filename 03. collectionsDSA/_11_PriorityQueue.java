/*

   NOTES:
   - PriorityQueue implements the Queue interface and is backed by a priority heap (a min-heap by default in Java).
   - Unlike a regular Queue (FIFO), PriorityQueue retrieves elements based on their priority, not insertion order.
   - Priority is determined by:
       1. Natural ordering (elements must implement Comparable)
       2. A custom Comparator passed in the constructor

   - Elements are **not** stored in sorted order; the heap structure only guarantees that the *head* element is the one with highest priority (smallest in a min-heap).
   - Traversal using an iterator **does not guarantee priority order** — it reflects internal heap structure.

   - DO NOT rely on iteration for processing elements in priority order. Use `poll()` repeatedly instead.

   - Common operations:
       - `offer(e)` or `add(e)` → insert element
       - `peek()` → view head
       - `poll()` → remove head

*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _11_PriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> ordered = new PriorityQueue<>();

        ordered.offer(11);
        ordered.offer(44);
        ordered.offer(33);
        ordered.offer(22);

        System.out.println(ordered); // [11, 22, 33, 44]

        // Get bottom 2 elements from the PriorityQueue
        List<Integer> bottom2List = new ArrayList<>();
        int index = 0;

        while (!ordered.isEmpty()) {
            if (index == 2)
                break;
            bottom2List.add(ordered.poll());
            index++;
        }

        System.out.println("Bottom 2 List : " + bottom2List); // [11, 22]
        System.out.println("Ordered Integer : " + ordered); // [33, 44]
    }
}