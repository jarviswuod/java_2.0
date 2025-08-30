/*

    NOTES:
    - List Types:
        - LinkedList
        - Iterator
        - ListIterator
        - ArrayList
        - Vector
        - Stack

    - vital rule
        - code against the interface, not the concrete class

    - List Features:
        - Allow duplicate
        - Allow multiple 'null' elements
        - Index is observed as in normal array starting from 0
        - Insertion order maintained

    - LinkedList vs ArrayList:
        - doublie linked list to store data, dynamic array to store data
        - faster manipulation, slow manipulation because it uses dynamic array internally
        - implements Both List, Queue and Deque; implement only List
        - Can be uses as either list, Queue or Deque, can only be uses as List
        - more memory consumption to store; data & refs to prev and next values
        - Good for manipulation, Good for stroing and accessing data


    - Utility methods
        - addAll(Collection c)
        - removeAll(Collection c)
        - retainAll(Collection c)
        - containsAll(Collection c)
        - Collections.sort(Collection c)
        - Collections.reverse(Collection c)

    - Stack Methods:
        - offer(element)
        - poll()
        - peek()

    - List Methods:
        - add(element)
        - remove(element)
        - get(element or index)
        - set(index, element)
        - contains(element)
        - size()
        - clear()
        - isEmpty()
        - indexOf(element)/ lastIndexOf(element)

    - Iterator Methods:
        - next()
        - hasNext()

    - ListIterator Methods:
        - next()
        - hasNext()
        - previous()
        - hasPrevious()

    - Sorting Lists:
        - comparable; natural ordering: compare(arg0)
        - comparator; total ordering: compareTo(arg0, arg1)

        - Collections.sort(Collectino c)
        - Collections.sort(Collectino c, (a, b) -> a - b);
        - Collections.reverse()

    - Looping through Lists:
        - basic for loop
        - Iterator for loop
        - Iterator while loop
        - Enhanced for loop
        - forEach loop
        - stream.forEach

 */

import java.util.Arrays;
import java.util.Iterator;

public class _02_List {
    public static void main(String[] args) {

        CustomList<Integer> customList = new CustomList<>();
        customList.add(12);
        customList.add(89);
        customList.add(45);
        customList.add(36);

        // System.out.println(customList);

        for (int i = 0; i < customList.size; i++) {
            System.out.println(customList.get(i));
        }

        System.out.println();

        for (int value : customList) {
            System.out.println(value);
        }
    }
}

class CustomList<T> implements Iterable<T> {
    T[] list;
    int size;

    public CustomList() {
        list = (T[]) new Object[10];
        size = 0;
    }

    public void add(T value) {
        list[size++] = value;
    }

    public T get(int index) {
        return list[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    @Override
    public Iterator<T> iterator() {
        return new Inner_02_List(this);
    }

    public class Inner_02_List implements Iterator<T> {
        private CustomList<T> list;
        int index;

        public Inner_02_List(CustomList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return list.size > index;
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}