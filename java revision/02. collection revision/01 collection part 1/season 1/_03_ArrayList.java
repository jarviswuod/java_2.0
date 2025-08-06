/*

   NOTES:
   Creating an ArrayList
       1. Using default constructor
            List<Integer> firstList = new ArrayList<>();
       2. Using Another Collection
            a. ArrayList(Collection c) constructor
                List<Integer> list1 = new ArrayList<>(firstList);
            b. Adding collection to an ArrayList .addAll()
                list1.addAll(list2);



   ArrayList methods
      - add(elementName)
      - add(index, elementName)
      - get(index)
      - set(index, elementName)
      - size()
      - isEmpty()
      - clear()
      - remove(index or elementName)
      - removeAll(Collection c)
      - indexOf(elementName) / lastIndexOf(elementName)



   - Iterating over an ArrayList
       1. Basic for loop
       2. Enhanced for loop
       3. Basic loop with iterator
       4. Iterator with while loop
       5. Java 8 stream + lamda example
       6. Java 8 forEach + lamda example



   - Sorting primitive datatype
       - sort()
            - Collections.sort(list1);
       - reverse()
            - Collections.reverse(list1);



    - Sorting Custom Objects Using Comparator interface
        - compare()
        - Converting compare() method to lambda expression

 */

public class _03_ArrayList {

    public static void main(String[] args) {

    }
}
