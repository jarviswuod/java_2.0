/*
    NOTES:

      - Collection interface methods
         - boolean containsAll(Collection<?> c) 
         - boolean addAll(Collection<? extends E > c) 
         - boolean removeAll(Collection<?> c) 
         - boolean retainAll(Collection<?> c) 
         - void clear()

      - Lists:
         - Lists are collections that maintain their elements in order and can contain duplicates
         - The elments in a list are ordered
         - Each element are position based, starting from index 0

      - List Methods:
         - E get(int index)
         - E set(int index, E element)
         - void add(int index, E element)
         - boolea addAll(int index, Collection<? extends E > c)
         - E remove(int index)

      - Implementations of List:
          - ArrayList
          - LinkedList
          - Vector

      - ArrayList:
         - ArrayList is a dynamic array
         - To be used when we don't know what is going to be the size of the array
         - Internally it uses a normal array , set to some default capacity
         - When the capacity is reached, it will create a new array of bigger size(50% of its curent capacity) and copied all the elements from the old array to the new array
         - New array's reference for it's internal usage
         - As the old array is no longer in use, it will be garbage collected in teh next garbae collection

      - Vector:
         - The Vector class is a legacy class which implements the List interface
         - The Vector and ArrayList classes are implemented using dynamically
         - Resizable arrays, providing fast random access (i.e position-based access) and fast
         - list traversal - very much like using an orddinary array
         - Unlike the ArrayList class, the Vector class is thread-safe, meaning that concurrent calls to the vector will not compromise it's integrity
         - The ArrayList and Vector classes offer comparable performance, but Vectors suffer a slight perfomance penalty due to synchronization

      - LinkedList:
         - The LinkedList implementation uses a doubly-linked list
         - Insertions and deletions in a double-linked list are very efficient
    
      - ArrayList vs LinkedList:
         - Position-based access has constant-time performance for the ArrayList and Vector classes
         - Position-based access is in linear time for a LinkedList owing to traversal in a doubly-linked list
         - When frequent insertions and deletions occur inside a list, a LinkedList can be worth considering
         - Overall, the ArrayList implementation is the best choice for implementing lists
         - In addition to the List interface, the LinkedList class also implements Deque Interface that allow it to be used for stacks and different kinds of queues

         
 */

public class _03_CollectionFramework {

   public static void main(String[] args) {

   }
}
