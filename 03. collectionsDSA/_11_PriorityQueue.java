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

        PriorityQueue<Integer> priority = new PriorityQueue<>();

        priority.offer(11);
        priority.offer(44);
        priority.offer(33);
        priority.offer(22);

        System.out.println(priority); // [11, 22, 33, 44]

        // Get bottom 2 elements from the PriorityQueue
        List<Integer> bottom2 = new ArrayList<>();
        int index = 0;

        while (!priority.isEmpty()) {
            if (index == 2)
                break;
            bottom2.add(priority.poll());
            index++;
        }

        System.out.println("List : " + bottom2); // [11, 22]
        System.out.println("PriorityQueue : " + priority); // [33, 44]
    }
}