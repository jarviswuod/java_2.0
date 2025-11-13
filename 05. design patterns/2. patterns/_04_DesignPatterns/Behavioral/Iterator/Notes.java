package _04_DesignPatterns.Behavioral.Iterator;

/*

    NOTES:
    - Iterator Pattern:
        - Is a behavioral pattern that provides a way of iterating over an object without exposing the object's internal structure plus changing the object's internals should not affect it's consumers


    - CHALLENGE:
        - We have a ShoppingList class which stores a list of items. It has a push() method to add items to the list, a pop() method to remove the last item from the list, and a getList() method that returns the whole shopping list. The list is currently stored in an ArrayList
        - How do we allow consumers to iterate over the list without knowing it's internal representation and such that if the internal representation is changed the consumers don't break


    - SOLUTION 1: Expose the internal representation:
        - We can use the Iterator Pattern to ensure that changing the internals i.e, changing the list data structure doesn't affect consumers. This is achieved by adding some methods to ShoppingList to allow iteration over the shopping list without knowing it's internals representation:

                ____________________
                | ShoppingList     |
                |__________________|                        Consumer:
                | push(item)       |                        ------------
                | pop()            |                          while(list.hasNext()) {
                | # next()         |                              int current = list.current();
                | # current()      |                              System.out.println(current);
                | # hasNext()      |                              list.next();
                |__________________|                          }

        
        - We've added three methods:
            # hasNext() : to check if there is another item on the list
            # current() : to fetch current item
            # next() : to go to the next item

        - With this structure, we don't have to know the internal representation of the 'lists' object. Meaning if we changed the data structure used in ShoppingList to store items, no consumers would break

        - SOLUTION 1 ISSUES:
            - The above class violates the SRP as it's both responsible for;
                1. List management using push() and pop() methods
                2. Iteration using next(), current(), and hasNext()



    - SOLUTION 2: SOLID PRINCIPLE OBSERVED:
        - To follow the SRP, we can put the iterator methods into a new class
                ____________________             ____________________
                | ShoppingList     |             | Iterator         |
                |__________________|             |__________________|
                | push(item)       |------------>| next()           |
                | pop()            |             | current()        |
                | createIterator() |             | hasNext()        |
                |__________________|             |__________________|


            - NOTE:
                - The createIterator() method returns an instance of Iterator to allow consumers iterate over shipping lists without internal details



        - SOLUTION 2 PROBLEM plus SOLUTION 3:
            - If the data structure in ShoppingList changes, then we will need a different iterator to manage it

            - To solve for this, we introduce an Iterator interface from which we can have concrete classed for each data structure that implements Iterator interface. This ensures the new data structure; array, List, Stack, etc always contains iterator's methods

                    ____________________          ____________________
                    | ShoppingList     |          | Iterator         |
                    |__________________|          |__________________|
                    | push(item)       |--------->| next()           |
                    | pop()            |          | current()        |
                    | createIterator() |          | hasNext()        |
                    |__________________|          |__________________|
                                                          ^
                                                          |
                                            ______________|__________________
                                            |                               |
                                    ________|___________       _____________|______
                                    | ListIterator     |       | ArrayIterator    |
                                    |__________________|       |__________________|
                                    |                  |       |                  |
                                    |__________________|       |__________________|


                NOTE:
                    - ShoppingList has a dependency to the Iterator interface, as createIterator() returns an object of type Iterator
                    - Both ListIterator and ArrayIterator concrete iterator classes implement the Iterator interface and overrides it's methods



    - ITERATOR PATTERN UML: From GoF book:

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
        - Employ Iterator pattern when your collection possesses a complex internal structure or one that is likely to change. This way your clients can iterate over the collection without any issues



    - Pros and cons:
        + Satisfies SRP; traversal logic is abstracted into separate classes
        + Satisfies OCP; you can create new collections and iterators without breaking the code that uses them

        - Can be over-engineering if your app only works with simple collections

 */

public class Notes {

}
