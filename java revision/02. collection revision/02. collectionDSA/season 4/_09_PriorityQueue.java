/*

    NOTES:
    - What I know about PriorityQueue:
        - Comparable interface implementation by default
            - compareTo(arg0)

        - Custom class has to implement Comparable or Comparator interface
            - You can define a Comparator interface on PriorityQueue just as below
                - PriorityQueue<Integer> pq = new PriorityQueue<>();
                    - Then add elements as normal


                                    OR
                - PriorityQueue<Integer> pq = new PriorityQueue<>(Collection c);

                 
                                    OR
                - PriorityQueue<CustomClass> pq = new PriorityQueue<>((arg0, arg1) -> arg0 - arg1);
                    - Then loop over an existing COllection or add a custom Collection


    - Looping over a PriorityQueue
        - Enhanced for Loop
        - iterator for loop
        - iterator while loop
        - forEach 
        - stream.forEach

 */

public class _09_PriorityQueue {

}
