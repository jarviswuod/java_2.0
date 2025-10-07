/*

    NOTES:
    - List:
        - 

    - Map:
        - 

    - Set:
        - 

    - Creating an a list:
        - Using default constructor
            - List names = new ArrayList<>();

        - Using another collection
            - List names = new ArrayList<>(Collection c);

        - Using addAll() method
            - List names = listNames.addAll(Collection c);



    - Collection methods:
        - containsAll()
        - addAll()
        - removeAll()


    - List methods:
        - indexOf()/ lastIndexOf()
        - contains()
        - add()
        - remove()
        - add(at, value)
        - get()
        - isEmpty()
        - size()
        - set(index, elementName)
        - clear()


    - Looping over list;
        - basic for loop
        - Enhanced for loop
        - for loop iterator
        - while loop iterator
        - forEach
        - stream


    - List subtypes;
        - ArrayList<>();
        - LinkedList<>();
        - Vector<>();
        - Stack<>();

    - Queue subtypes:
        - LinkedList<>();
        - Stack<>();
        - Deque<>();

    - Set subtypes;
        - HashSet<>()
        - TreeSet<>()
        - LinkedHashSet<>()


    - Map subtypes;
        - HashMap<>()
        - Hashtable<>()
        - TreeMap<>()
        - LinkedHashMap<>()

    - Rules:
        - Always code against the interface not concrete classes
        - 


    - Stack:
        peek()
        pop()
        push()

    - Other:
        - poll()
        - peek()
        - offer()



   - Sorting primitive datatype
       - sort()
            - Collections.sort(list1);
       - reverse()
            - Collections.reverse(list1);



    - Sorting Custom Objects Using Comparator interface
        - compare(arg0, arg1)
        - compareTo(value)

 */

import java.util.Queue;
import java.util.LinkedList;

public class _01_Collection {
    public static void main(String[] args) {
        Queue<Integer> went = new LinkedList<>();
        went.offer(12);
    }
}