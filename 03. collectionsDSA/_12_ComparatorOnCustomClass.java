/*
    NOTES:
      - Intentionally using both total ordering and partial ordering
      - In my case im using total ordering to pick the top 3 elements (in physics marks)
      - Natural ordering is doing it's ordering to pick bottom 3 elements (in math marks)
      - By default, right now, total ordering is implemented in the class via the lambda expression   


      CHANGING THE NATURAL ORDER I.E FROM INCREASING TO DECREASING ORDER

 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _12_ComparatorOnCustomClass {

    public static void main(String[] args) {

        // Get me the top students according to their physics marks

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        PriorityQueue<StudentsMarks> priority = new PriorityQueue<>((s1, s2) -> s2.getPhysics() - s1.getPhysics());

        for (StudentsMarks student : marks) {
            priority.offer(student);
        }

        List<StudentsMarks> top3 = new ArrayList<>();
        int index = 0;

        while (!priority.isEmpty()) {
            if (index == 3)
                break;
            top3.add(priority.poll());
            index++;
        }

        System.out.println(top3);
        System.out.println(priority);
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
        return this.maths - arg0.maths;
    }

}