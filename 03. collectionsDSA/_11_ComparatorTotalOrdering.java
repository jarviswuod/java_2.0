
/*
    NOTES:
     - Natural ordering -> Whatever ordering the class is implementing
     - Total ordering -> Whatever ordering you are passing to the PriorityQueue
     - Total ordering always has preference over Natural ordering


 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _11_ComparatorTotalOrdering {

    public static void main(String[] args) {
        PriorityQueue<Integer> priority = new PriorityQueue<>(new MyCustomComparator());

        priority.offer(11);
        priority.offer(22);
        priority.offer(33);
        priority.offer(44);

        // TOP 2 ELEMENTS
        List<Integer> top2 = new ArrayList<>();
        int index = 0;

        while (!priority.isEmpty()) {
            if (index == 2)
                break;
            top2.add(priority.poll());
            index++;
        }

        System.out.println(top2);
        System.out.println(priority);
    }
}

class MyCustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer arg0, Integer arg1) {
        return arg1 - arg0;
    }
}

// class StudentsMarks {
// private int maths;
// private int physics;

// public StudentsMarks(int maths, int physics) {
// this.maths = maths;
// this.physics = physics;
// }

// public int getMaths() {
// return maths;
// }

// public int getPhysics() {
// return physics;
// }

// @Override
// public String toString() {
// return "StudentsMarks [maths=" + maths + ", physics=" + physics + "]";
// }

// }

// class MyCustomComparator_ implements Comparator<StudentsMarks> {

// @Override
// public int compare(StudentsMarks arg0, StudentsMarks arg1) {
// return arg0.getMaths() - arg1.getMaths();
// }
// }