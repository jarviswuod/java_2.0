/*
    NOTES:

      - List:
         - Are collections that can contain duplicate elements
         - The elements are ordered starting from index 0(position-based access)
         - List implementations:
             - ArrayList
             - LinkedList
             - Vector

         - List Methods:
             - E get(int index)
             - E set(int index, E element)
             - void add(int index, E element)
             - boolea addAll(int index, Collection<? extends E > c)
             - E remove(int index)

        - Collection interface methods
             - containsAll(Collection<?> c) 
             - addAll(Collection<? extends E > c) 
             - removeAll(Collection<?> c) 
             - retainAll(Collection<?> c) 
             - clear()


         - ArrayList(dynamic array):
             - Used when we don't know the size of the array
             - Internally it uses a normal array set to some default capacity
             - When the capacity is reached, it creates a new bigger sized array(50% curent capacity) then copies all the elements to the new array
             - New array's reference for it's internal usage. As the old array will be garbage collected in the next garbage collection since it's no longer in use


         - Vector(legacy dynamic array):
             - Unlike the ArrayList class, the Vector class is thread-safe, i.e concurrent calls to the Vector will not compromise it's integrity
             - Vectors suffer a slight perfomance penalty due to synchronization to ArrayList


         - LinkedList:
             - The LinkedList implementation uses a doubly-linked list
             - Insertions and deletions in a double-linked list are very efficient

      - ArrayList vs LinkedList:
         - Position-based access has constant-time performance for the ArrayList and Vector classes
         - Position-based access is in linear time for a LinkedList owing to traversal in a doubly-linked list
         - When frequent insertions and deletions occur inside a list, a LinkedList can be worth considering
         - Overall, the ArrayList implementation is the best choice for implementing lists
         - LinkedList class implements both List and Deque Interfaces to allow usage for stacks and queues

 */

public class _04_ListInterface {

    public static void main(String[] args) {

    }
}
