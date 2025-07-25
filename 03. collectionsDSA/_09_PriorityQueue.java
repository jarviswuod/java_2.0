/*

    NOTES:
     - Prioriry queue works on priority
     - The implementation is based on priority heap, a tree like strucure that yields an element at the head of the queue accoring to the priority ordering, which is defined either by the natural ordering of its elements or by a comparator.
     - In the case of several elments having the same priority, one of them is chosen arbitrarily
     - Elements of a PriorityQueue are not sorted
     - The queue only guaranteed that elements can be removed in priority order, and any traversal using interator does not

     - Travers NOT iterate over the PriorityQueue
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _09_PriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> priority = new PriorityQueue<>();

        priority.offer(11);
        priority.offer(22);
        priority.offer(33);
        priority.offer(44);

        // BOTTOM 2 ELEMENTS
        List<Integer> bottom2 = new ArrayList<>();
        int index = 0;

        while (!priority.isEmpty()) {
            if (index == 2)
                break;
            bottom2.add(priority.poll());
            index++;
        }

        System.out.println(bottom2);
        System.out.println(priority);
    }
}
