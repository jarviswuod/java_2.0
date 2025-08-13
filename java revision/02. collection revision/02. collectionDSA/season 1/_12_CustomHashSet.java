/*

    NOTES:
    - Custom HashSet
        - If you don't override equals() and hashcode() methods, the default implementation will be used which is based on the memory address of the object. This means that even if two objects have the same content, they will be considered different if they are not the same object in memory.
        - If two objects are equal according to equals() method, they must have the same hashcode.

        - contains() process:
            - hashcode: -> Memory address of the object
            - equals: -> Compares the content of the object/reference

        - KEY:
            - Always override equals() and hashcode() of your custom class before using it in a HashSet

 */

public class _12_CustomHashSet {

}