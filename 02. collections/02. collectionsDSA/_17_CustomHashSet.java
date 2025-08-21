/*

    NOTES:
    - Custom HashSet
        - Whenever you insert an element into a HashSet, a hashcode for that element is being generated and then mapped to a particular bucket and then from the bucket it checks the hashcode of all other elements. If it finds a match, it checks the equals() method to see if the content is same or not.
            2 things happen here:
                - 1. If the hashcode matches, it checks the equals() method
                - 2. If the hashcode does not match, it will not check the equals() method and will just insert the element into the HashSet
        - If you don't override equals() and hashcode() methods, the default implementation will be used which is based on the memory address of the object. This means that even if two objects have the same content, they will be considered different if they are not the same object in memory.
        - If you override equals() method, you must also override hashcode() method to maintain the contract between equals() and hashcode() methods. If two objects are equal according to equals() method, they must have the same hashcode.

        - contains() process:
            - hashcode: -> Memory address of the object
            - equals: -> Compares the content of the object/reference

    - KEY:
        - Always override equals() and hashcode() of your custom class before using it in a HashSet

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _17_CustomHashSet {

    public static void main(String[] args) {

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        Set<StudentsMarks> marksHashSet = new HashSet<>(marks);

        for (StudentsMarks student : marksHashSet) {
            System.out.println(student);
        }

        // contains() method
        System.out.println(marksHashSet.contains(new StudentsMarks(70, 80)));

    }
}

class StudentsMarks {
    private int maths;
    private int physics;

    public StudentsMarks(int maths, int physics) {
        this.maths = maths;
        this.physics = physics;
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    @Override
    public String toString() {
        return "StudentsMarks [maths=" + maths + ", physics=" + physics + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maths;
        result = prime * result + physics;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentsMarks other = (StudentsMarks) obj;
        if (maths != other.maths)
            return false;
        if (physics != other.physics)
            return false;
        return true;
    }
}