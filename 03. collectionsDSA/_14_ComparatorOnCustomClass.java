/*

    NOTES:
    - Intentionally using both Comparable Interface(Natural ordering) and Comparator Interface(Total ordering)
        - Total ordering to pick the bottom 3 elements (in math marks)
        - Natural ordering to pick top 3 elements (in physics marks)
    
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _14_ComparatorOnCustomClass {

    public static void main(String[] args) {

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        PriorityQueue<StudentsMarks> classMarks = new PriorityQueue<>(new MyCustomComparator());
        PriorityQueue<StudentsMarks> lamdaMarks = new PriorityQueue<>((s1, s2) -> s1.getMaths() - s2.getMaths());

        for (StudentsMarks student : marks) {
            classMarks.offer(student);
            lamdaMarks.offer(student);
        }

        List<StudentsMarks> bottom3 = new ArrayList<>();
        int index = 0;

        while (!lamdaMarks.isEmpty()) {
            if (index == 3)
                break;
            bottom3.add(lamdaMarks.poll());
            index++;
        }

        System.out.println("bottom 3 Physics students : " + bottom3);
        System.out.println();

        System.out.println("Lambda marks : " + lamdaMarks);
        System.out.println();

        System.out.println("ComparatorClass marks : " + classMarks);
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
    public int compareTo(StudentsMarks arg0) {
        return this.physics - arg0.physics;
    }
}

class MyCustomComparator implements Comparator<StudentsMarks> {

    @Override
    public int compare(StudentsMarks arg0, StudentsMarks arg1) {
        return arg0.getMaths() - arg1.getMaths();
    }
}