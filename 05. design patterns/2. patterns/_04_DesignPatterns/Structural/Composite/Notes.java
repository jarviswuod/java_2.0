package _04_DesignPatterns.Structural.Composite;

/*

    NOTES:
    - The Composite Design Pattern:
        - Is a structural design pattern that enables the creation of tree-like structures to represent collections of objects where both individual objects and groups of objects are treated in a unified manner
        - It handles individual objects and object compositions uniformly allowing clients to work with complex structures and particular object using a single interface

    - CHALLENGE:
        - Let's say that we get an Amazon delivery of a large package that contains multiple items;

                                         package:
                                            |
                                            |
                            ________________|________________
                            |                               |
                            v                               v
                           Box                             Box
                            |                               |
                            v                  _____________|_____________
                        Microphone             |                         |
                                               v                         v
                                              Box                       Box
                                               |                         |
                                               v                         v
                                             Mouse                     Keyboard


        - As you can see, a box can contain an item or groups of other boxes. The diagram shows how a package of items can be represented as a tree structure
        - If we needed to find the total price of items within any package. The solution would be creating an array of boxes and items then loop through them recursively to find total price of the package



    - SOLUTION 1: Array Loop:
        - The solution calculates the total price correctly, but it has some obvious issues:
            - The calculateTotalPrice() method contains lots of conditions making it hard to read
            - OCP is violated: Whenever we add a new item we have to modify Box class



    - SOLUTION 2:
        - Whenever we have lots of conditionals that are checking type of an object and then casting it to that object type. It's a good sign that we need to use polymorphism
        - We can use polymorphism by creating an Item interface and extracting common methods or logic between the objects into that interface

                                            ______________
                        |------------------>| Item       |
                        |                   |____________|
                        |                   | getPrice() |
                        |                   |____________|
                        |                         ^
                        |                         |
                        |              ___________|____________
                        |              |                      |   
                        |     ____________________      ______________
                        |---<>| Box              |      | Mouse      | 
                              |__________________|      |____________|-|
                              | items: Item[]    |      | getPrice() | |-|
                              |__________________|      |____________| | |
                              | getPrice()       |        |____________| |
                              |__________________|          |____________|


        - A box is essentially composed of a group of items (represented by the diamond arrow) but is also an item itself(represented by the arrow). A box is just a group of items
        - Now, a box and it's components can be treated the same way as Items, thanks to polymorphism




    - COMPOSITE PATTERN UML: From GoF book:
                                               ______________
                        |--------------------->| Component  |
                        |                      |____________|
                        |                      | execute()  |
                        |                      |____________|
                        |                            ^
                        |                            |
                        |                 ___________|____________
                        |                 |                      |   
                        |     _________________________     _____________
                        |---<>| Composite             |     | Leaf      | 
                              |_______________________|     |___________|-|
                              | children: Component[] |     | execute() | |-|
                              |_______________________|     |___________| | |
                              | add(c: Component)     |       |___________| |
                              | execute()             |         |___________|
                              |_______________________|   


        - Use cases:
            - The composite pattern is useful for representing tree structure. Example:
                1. Folder and files
                2. A graphical editor, that allows you to group shapes together, and group groups of shapes together. When dragging a group, all shapes should move together in the same way

 */

public class Notes {

}
