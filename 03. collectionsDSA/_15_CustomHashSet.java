/*
    NOTES:
    - equals: -> Compares the content of the object/reference
    - hashcode: -> Memory address of the object
    - contains()

    - Always override equals() and hashCOde() of your custom class before using it in a HashSet
    
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _15_CustomHashSet {

    public static void main(String[] args) {

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        Set<StudentsMarks> hashSet = new HashSet(marks);

        for (StudentsMarks student : hashSet) {
            System.out.println(student);
        }

        // contains() method
        System.out.println(hashSet.contains(new StudentsMarks(70, 80)));

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