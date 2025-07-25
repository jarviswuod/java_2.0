/*
    NOTES:
      - Comparators and comparable interface


    @Override
    public int compareTo(StudentsMarks arg0) {
        
        current obj < other obj return -1;
        current obj > other obj return 1;
        current obj == other obj return 0;
       

        if (this.maths < arg0.maths)
            return -1;
        if (this.maths > arg0.maths)
            return 1;
        if (this.maths == arg0.maths)
            return 0;

        return this.maths - arg0.maths;
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _10_PriorityQueueInCustomClass {

    public static void main(String[] args) {

        // Get me the top students according to their maths marks

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        PriorityQueue<StudentsMarks> priority = new PriorityQueue<>(marks);

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