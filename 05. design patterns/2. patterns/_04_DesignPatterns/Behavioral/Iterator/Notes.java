package _04_DesignPatterns.Behavioral.Iterator;

/*

    NOTES:
    - Iterator Pattern:
        - A Pattern provides a way of iterating over an object without having to expose the object's internal structure, which may change in the future. Changing the internals of an object shouldnot affect it's consumers


    - CHALLENGE:
        - We have a ShoppingList class which stores a list of items, we have a push method to add items to the list, and a pop method to remove the last item from the list. and we ahve a getList() method which returns the whole shopping list. list The list is stored as an array internally. HOw do we allow consumers to iterate over the list without knowing it's internal representation, so that if we change the internal representation, the consumers don't break



    - SOLUTION 1: Expose the internal representation:
        - We can use the Iterator Pattern to ensure that changing the internals i.e, changing the list data structure doesn't affect consumers. We can add some methods to ShoppingList to allow iterating over a shopping list object, without knowing it's internals representation:

                ____________________
                | ShoppingList     |
                |__________________|                        Consumer:
                | push(item)       |                        ------------
                | pop()            |                          while(list.hasNext()) {
                | # next()         |                              int current = lisst.current();
                | # current()      |                              System.out.println(current);
                | # hasNext()      |                              list.next();
                |__________________|                          }

        
        - EXPLANATION:
            - We've added three methods to help consumers to iterate ovet the ovject without knowledge of the internal data structures:
                # next() : goes to the next item
                # current() : the current item
                # hasNext() : checked if there is another item

            - With this structure, we dont have to know the internal representation of the lists object, so if we changed the data structure used in ShoppingList to store items, it's consuders wouldn't break or need to be changed. We'd just have to update the iterator methods to account for the new data structure

            -  SOLUTION 1 PROBLEM:
                - THe above class violated the SOLID single responsiblity principle
                    1. It's responsiblity for list management, using push and pop()
                    2. It's responsiblity for iteration, using next(), current() and hasNext()


    - SOLUTION 2: follow the SRP:
        - To follow the SRP, we can put the iterator methods into a new class
                ____________________             ____________________
                | ShoppingList     |             | Iterator         |
                |__________________|             |__________________|
                | push(item)       |------------>| next()           |
                | pop()            |             | current()        |
                | createIterator() |             | hasNext()        |
                |__________________|             |__________________|

            - NOTE:
                - The createIterator() method returns an instance of Iterator that allows consumers to iterate over shipping lists without internal details


        - SOLUTION 2 PROBLEM plus SOLUTION 3:
            - If the data structure in ShoppingList changes, then we will need a different iteator to manage it. 
            
            - So Iterator needs to be an interface, and then we can have concrete classed for each data structure that implement Iterator to ensure they contain the iterator methods. The interface determines the capabilities we need from a real concrete iterator. The data structures could be array, List, Stack, etc

                ____________________             ____________________
                | ShoppingList     |             | Iterator         |
                |__________________|             |__________________|
                | push(item)       |------------>| next()           |
                | pop()            |             | current()        |
                | createIterator() |             | hasNext()        |
                |__________________|             |__________________|
                                                        ^
                                                        |
                                    _____________________________________
                                    |                                   |
                            ____________________           ____________________
                            | ListIterator     |           | ArrayIterator    |
                            |__________________|           |__________________|
                            |                  |           |                  |
                            |__________________|           |__________________|


        - ShoppingList has a dependency to the Iterator interface, as createIterator() returns an object of type Iterator. The concrete iterator classes extend Iterator and implements it's methods.

    - Here's hwo our solution looks when using the GoF Iterator Pattern abstract class names;

                ____________________             ____________________
                | Collection       |             | Iterator         |
                |__________________|------------>|__________________|
                | createIterator() |             | next()           |
                |__________________|             | current()        |
                                                 | hasNext()        |
                                                 |__________________|
                                                        ^
                                                        |
                                                 ____________________
                                                 | ConcreteIterator |
                                                 |__________________|-|
                                                 | next()           | |-|
                                                 | current()        | | |
                                                 | hasNext()        | | |
                                                 |__________________| | |
                                                   |__________________| |
                                                     |__________________|

    -  When to use Iterator Pattern
        - Employ Iterator pattern when your collection possesses a complexf internal strcutre, or a data strcutre that is likely to change, so that clients can iterate over the collection without any knowledge of the data structure

    - Pros and cons:
        + Satisfies SRP: traversal logic is abstracted into separate classes.
        + Satisfies Open/closed Principle: you can create  new collections and iterators without breaking the code that uses them

        - Can be over-engineering if your app only works with simple collections

 */

public class Notes {

}
