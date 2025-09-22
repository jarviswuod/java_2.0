package _04_DesignPatterns.Structural.Composite;

/*


    NOTES:
    - The Composite Design Pattern:
        - Is a structural design pattern that enables the creating of tree-like structures to represent collections of objects where both individual objects and groups of objects are treated in a unified manner


    - CHALLENGE:
        - Let's say that we get an Amazon delivery of a large package that contains multiple items;

                                        package:
                                            |
                                            |
                                    ________|________________________
                                    |                                |
                                    v                                v
                                Box                              Box
                                    |                                |
                                    v                        ________|__________________________
                                    Microphone              |                                  |
                                                            v                                  v
                                                        Box                                Box
                                                            |                                  |
                                                            v                                  v
                                                            Mouse                              Keyboard


        - As you can see, boxes can contain groups of other boxes and items. THe diagram shows how a package of items can be represented as a tree structure
        - Say that we needed to find the total price of items within any package. THe solution that natrually pops in teh head is to create an array of boxes and items, the loop through them recursivly to find total price of the package



    - SOLUTION 1: Array Loop;
        - The solution calulates the total price correttly, but in has some obvious issues;
            - The calculateTotalPrice() method contains lors of conditions. This is hard to read
            - OCP is violated; whenever we add a new item, we have to modify Box


    - SOLUTION 2:
        - Whever we have lots of conditionals that are checking the type of an object, and casting it to another object type it;s a good sign that we need to use polymorphism
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

        - A box is essentially composed of a group of items(represented by the diamod arrow), but is also an item itself(represented by the arrow). A box is simply just a group of items.
        - Now, a boxand it's components can be treated the same way - as items - thanks to polymorphism

    - GoF COMPOSITE PATTERN:

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
            - Folder and files
            - A graphical editor, that allows you to group shapes together, and group groups of shapes together. When dragging a group, all shapes should move together in the same way

 */

public class Notes {

}
