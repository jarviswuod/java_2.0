package _04_DesignPatterns.Structural.Composite;

/*

    NOTES:
    - The Composite Design Pattern:
        - Is a structural design pattern that enables the creation of tree-like structures to represent collections of objects where both individual objects and groups of objects are treated in a unified manner


    - CHALLENGE:
        - Let's say that we get an Amazon delivery of a large package that contains multiple items;

                                        package:
                                            |
                                            |
                            ________________|_________________
                            |                                |
                            v                                v
                           Box                              Box
                            |                                |
                            v                   _____________|______________________
                        Microphone              |                                  |
                                                v                                  v
                                               Box                                Box
                                                |                                  |
                                                v                                  v
                                              Mouse                              Keyboard


        - As you can see, boxes can contain groups of other boxes and items. The diagram shows how a package of items can be represented as a tree structure
        - Say that we needed to find the total price of items within any package. The solution that naturally pops in the head is to create an array of boxes and items, the loop through them recursively to find total price of the package



    - SOLUTION 1: Array Loop;
        - The solution calculates the total price corretly, but it has some obvious issues;
            - The calculateTotalPrice() method contains lots of conditions. This is hard to read
            - OCP is violated; whenever we add a new item, we have to modify Box class



    - SOLUTION 2:
        - Whenever we have lots of conditionals that are checking the type of an object, and casting it to another object type it's a good sign that we need to use polymorphism
        - We can use polymorphism by creating an interface, called Item and extracting common methods or logic between the objects into that interface

                                  ______________
              ------------------->| Item       |
              |                   |____________|
              |                   | getPrice() |
              |                   |____________|
              |                         ^
              |                         |
              |              ___________|_______________________
              |              |                                 |   
              |     ____________________              ______________
              |---<>| Box              |              | Mouse      | 
                    |__________________|              |____________|-|
                    | items: Item[]    |              | getPrice() | |-|
                    |__________________|              |____________| | |
                    | getPrice()       |                |____________| |
                    |__________________|                  |____________|

        - A box is essentially composed of a group of items(represented by the diamond arrow), but is also an item itself(represented by the arrow). A box is simply just a group of items
        - Now, a box and it's components can be treated the same way as Items, thanks to polymorphism




    - COMPOSITE PATTERN UML: From GoF book:
                                  ______________
              ------------------->| Component  |
              |                   |____________|
              |                   | execute()  |
              |                   |____________|
              |                         ^
              |                         |
              |              ___________|_______________________
              |              |                                 |   
              |     _________________________              ______________
              |---<>| Composite             |              | Leaf       | 
                    |_______________________|              |____________|-|
                    | children: Component[] |              | execute()  | |-|
                    |_______________________|              |____________| | |
                    | add(c: Component)     |                |____________| |
                    | execute()             |                  |____________|
                    |_______________________|


        - The composite pattern is useful for representing tree structure, example;
            1. Folder and files
            2. A graphical editor, that allows you to group shapes together, and group groups of shapes together. When dragging a group, all shapes should move together in the same way

 */

public class Notes {

}
