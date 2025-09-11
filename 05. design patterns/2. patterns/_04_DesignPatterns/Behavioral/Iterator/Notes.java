package _04_DesignPatterns.Behavioral.Iterator;

/*

    NOTES:
    - The Iterator Pattern provides a way of iterating over an object without having to expose the object's internal structure, which may change in the future. Changing the internals of an object shouldnot affect it's consumers

    - We can use the Iterator Pattern to ensure that changing the internals i.e, changing the list data structure doesn't affect consumers. We can add some methods to ShoppingList to allow iterating over a shopping list object, without knowing it's internals representation:

                |-------------------|
                |  ShoppingList     |
                |-------------------|
                |  push(item)       |
                |  pop()            |
                |  next()           |
                |  current()        |
                |  hasNext()        |
                |-------------------|

        - Consumer:
            while(list.hasNext()) {
                int current = lisst.current();
                System.out.println(current);
                list.next();
            }
        
        - ISSUE:
            - We've added three methods to help consumers to iterate ovet the ovject without knowledge of the internal data structures:
                - next() : goes to the next item
                - current() : the current item
                - hasNext() : checked if there is another item

            - With this structure, we dont have to know the internal representation of the lists object, so if we changed the data structure used in ShoppingList to store items, it's consuders wouldn't break or need to be changed. We'd just have to update the iterator methods to account for the new data structure

            - PROBLEM: THe above class violated the SOLID single responsiblity principle
                1. It's responsiblity for list management, using push and pop()
                2. It's responsiblity for iteration, using next(), current() and hasNext()
            
            - To follow the SRP, we can put the iterator methods into a new class

                |-------------------|             |-------------------|
                |  ShoppingList     |             |  Iterator         |
                |-------------------|             |-------------------|
                |  push(item)       |------------>|  next()           |
                |  pop()            |             |  current()        |
                |  createIterator() |             |  hasNext()        |
                |-------------------|             |-------------------|

        - The createIterator() method returns an instance of Iterator that allows consumers to iterate over shipping lists without internal details

        - PROBLEM:
            - If the data structure in ShoppingList changes, then we will need a different iteator to manage it. So Iterator needs to be an interface, and then we can have concrete classed for each data structure that implement Iterator to ensure they contain the iterator methods. The interface determines the capabilities we need from a real concrete iterator. The data structures could be array, List, Stack, etc

                |-------------------|             |-------------------|
                |  ShoppingList     |             |  Iterator         |
                |-------------------|             |-------------------|
                |  push(item)       |------------>|  next()           |
                |  pop()            |             |  current()        |
                |  createIterator() |             |  hasNext()        |
                |-------------------|             |-------------------|
                                                        ^
                                                        |
                                    |-----------------------------------|
                                    |                                   |
                            |-------------------|           |-------------------|
                            |  ListIterator     |           |  ArrayIterator    |
                            |-------------------|           |-------------------|
                            |                   |           |                   |
                            |-------------------|           |-------------------|

        - ShoppingList has a dependency to the Iterator interface, as createIterator() returns an object of type Iterator. The concrete iterator classes extend Iterator and implements it's methods.

        - Here's hwo our solution looks when using the GoF abstract class names;

                |-------------------|             |-------------------|
                |  Collection       |             |  Iterator         |
                |-------------------|------------>|-------------------|
                |  createIterator() |             |  next()           |
                |-------------------|             |  current()        |
                                                  |  hasNext()        |
                                                  |-------------------|
                                                        ^
                                                        |
                                                 |-------------------|
                                                 |  ConcreteIterator |
                                                 |-------------------|-|
                                                 |  next()           | |-|
                                                 |  current()        | | |
                                                 |  hasNext()        | | |
                                                 |-------------------| | |
                                                   |-------------------| |
                                                     |-------------------|

    -  When to use Iterator Pattern
        - Employ Iterator pattern when your collection possesses a comples internal strcutre, or a data strcutre that is likely to change, so that clients can iterate over the collection without any knowledge of the data structure

    - Pros and cons:
        + Satisfies SRP: traversal logic is abstracted into separate classes.
        + Satisfies Open/closed Principle: you can create  new collections and iterators without breaking the code that uses them

        - Can be overengineering if your app only works with simple collections

 */

public class Notes {

}
