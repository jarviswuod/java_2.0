/*
        NOTES:
         - Extends the SortedSet interface with naviation methods to find the closest matches for specific search targets
         - By navigation, we mean operations that require searching for elements in the navigable set.
         - In the absense of elements, these operation return null rather than throwing an exception(NoSuchElementException)
         - In addition to the methods of the Sorted interface, the NaviableSet interface adds the follwowing methods:
             - E pollFirst() (removes and returns the first element)
             - E pollLast() (removes and returns the last element)
             - E lower(E e) (returns the greatest element less than e)
             - E ceiling(E e) (returns the least element greater than or equal to e)
             - E floor(E e) (returns the greatest element less than or equal to e)
             - E higher(E e) (returns the least element greater than e)
             - E lower(E e) (returns the greatest element less than e)
 */

public class _18_NavigableSet {

    public static void main(String[] args) {

    }
}
