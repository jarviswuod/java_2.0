/*

    NOTES:
    - When we try to add a custom StudentsMarks object into the PriorityQueue and we attempt to return the top3 student, we get an error due to fall to an exception. The Exception arises because the PriorityQueue does not know how to compare the StudentsMarks objects
            - class StudentsMarks cannot be cast to class java.lang.Comparable (StudentsMarks)

    - For Integer it works because an Integer wrapper class implements Comparable interface which PriorityQueue uses to compare the elements
            - public final class Integer extends Number implements Comparable<Integer> {...}

    - Comparable & Comparator interfaces are introduced to solve the Exception issue around PriorityQueue sorting in our custom StudentsMarks class

    - Whenever you are creating a custom class and want the custom class be the type of PriorityQueue. You should implement the Comparable class
            - class StudentsMarks implements Comparable<StudentsMarks> {...}

    - The Comparable interface forces you to override the compareTo() method. The compareTo() method has an object passed to it, basically want to compare 'this' specific object instance with the object being passed into our compareTo()
            @Override
            public int compareTo(StudentsMarks arg1) {
                return this.maths - arg1.maths;
            }

    - We have 3 situations;
            - (current obj < other obj) return -1;
            - (current obj > other obj) return 1;
            - (current obj == other obj) return 0;
    
    - At this point when we try to sort the StudentsMarks with help of the a PriorityQueue we face no issue since the PriorityQueue sees the Comparable interface implemented with comparedTo() method in place for sorting based on a logic we want

    - We want to get the top students according to their **math** marks
        - We pass in the Collection which has the Comparable interface implemented and compareTo() method set
             
            PriorityQueue<StudentsMarks> orderedMarks = new PriorityQueue<>(marks);

 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _12_ComparableInterface {

    public static void main(String[] args) {

        // Get me the top students according to their maths marks

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        PriorityQueue<StudentsMarks> orderedMarks = new PriorityQueue<>(marks);

        System.out.println("Ordered Marks Start : " + orderedMarks);

        List<StudentsMarks> top3Students = new ArrayList<>();
        int index = 0;

        while (!orderedMarks.isEmpty()) {
            if (index == 3)
                break;
            top3Students.add(orderedMarks.poll());
            index++;
        }

        System.out.println("Top 3 List marks : " + top3Students);
        System.out.println();

        System.out.println("Ordered Marks : " + orderedMarks);
    }
}

class StudentsMarks implements Comparable<StudentsMarks> {
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
    public int compareTo(StudentsMarks arg1) {
        return this.maths - arg1.maths;
    }
}