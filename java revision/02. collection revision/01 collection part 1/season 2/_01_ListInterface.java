
/*

 List interface
    Use dynamic arrays in the background
    Maintain insertion order
    Takes on duplicate elements
    Takes in multiple null values
    indexing start from 0 just like in arrays


    Creating a List object
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(Collection c);
        

    List methods
         - clear()
         - add(elementName)
         - insert(index, elementName)
         - indexOf(elementName)/ lastIndexOf(elementName)
         - remove(elementName or index)
         - removeAll(Collectino c)
         - addAll(Collection c)
         - size()
         - get(index)
         - set(index, elementName)
         - set(elementName)
         - isEmpty()
         - contains(elementName)
         - containsAll(Collection c)
         - retainAll(Collection c)

    LinkedList methods
        addFirst(elementName)
        addLast(elementName)
        removeFirst(elementName)
        removeLast(elementName)
        getFirst(elementName)
        getLast(elementName)

    sorting
        Collections.sort(Collection c)
        Collections.reverse(Collection c)

        Collections.sort(Collection c, Comparator com)

    Looping/ Iterating over a List
        Basic for
            for(int i = 0; i<list.size();i++) {
                System.out.println(list.get(i));
            }

        Enhanced for Loop
            for(Integer i: list){
                System.out.println(i);
            }

        forEach loop
            list.forEach(el->System.out.println(el));

        stream forEach loop
            list.stream().forEach(el->System.out.println(el));

        for iterator
            for(Iterator<Integer> iterator=list.iterator();iterator.hasNext();){
                System.out.println(iterator.next());
            }

        while iterator
            Iterator<Integer> iterator= list.iterator();

            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }



    LinkedList vs ArrayList
        LL -> both Deque, Queue and List interfaces, AL -> List
        LL -> Large size(dt, nx,pr),  AL -> el only
        LL -> doubly linked list, AL -> dynamic array
        LL -> fast, AL -> slow coz of dynamic arrays
        LL -> manupulating, LL -> Storing

 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _01_ListInterface {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(32);
        list.add(44);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (Integer i : list) {
            System.out.println(i);
        }

        list.forEach(el -> System.out.println(el));

        list.stream().forEach(el -> System.out.println(el));
    }
}